package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class CarParking implements Parking {
    private int truckSize;
    private int passengerSize;
    private final List<Car> cars;

    public CarParking(int truckSize, int passengerSize) {
        this.truckSize = truckSize;
        this.passengerSize = passengerSize;
        this.cars = new ArrayList<>(truckSize + passengerSize);
    }

    @Override
    public boolean add(Car car) {
        boolean result = false;
        int size = car.getSize();
        if (size > 1) {
            if (truckSize > 0) {
                cars.add(car);
                truckSize -= 1;
                result = true;
            } else if (passengerSize >= size) {
                cars.add(car);
                passengerSize -= size;
                result = true;
            }
        } else if (car.getSize() == 1 && passengerSize > 0) {
            cars.add(car);
            passengerSize -= 1;
            result = true;
        }
        return result;
    }

    @Override
    public List<Car> findAll() {
        return new ArrayList<>(cars);
    }
}
