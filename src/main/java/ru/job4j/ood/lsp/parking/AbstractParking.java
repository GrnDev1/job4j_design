package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractParking implements Parking {
    private final int truckSize;
    private final int passengerSize;
    List<Car> cars;

    public AbstractParking(int truckSize, int passengerSize) {
        this.truckSize = truckSize;
        this.passengerSize = passengerSize;
        this.cars = new ArrayList<>(truckSize + passengerSize);
    }

    @Override
    public boolean add(Car car) {
        return false;
    }

    @Override
    public List<Car> findAll() {
        return new ArrayList<>(cars);
    }
}
