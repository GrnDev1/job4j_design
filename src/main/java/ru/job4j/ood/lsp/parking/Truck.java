package ru.job4j.ood.lsp.parking;

import java.util.List;

public class Truck extends PassengerCar  implements Car {
    private List<Integer> passengerPlaces;

    public Truck(int id, int size) {
        super(id, size);
    }

    public List<Integer> getPassengerPlaces() {
        return passengerPlaces;
    }

    public void setPassengerPlaces(List<Integer> passengerPlaces) {
        this.passengerPlaces = passengerPlaces;
    }
}
