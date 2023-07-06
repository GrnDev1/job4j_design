package ru.job4j.ood.lsp.parking;

import java.util.Objects;

public class PassengerCar implements Car {
    protected int id;
    private final int size = 1;

    public PassengerCar() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "PassengerCar{"
                + "id=" + id
                + ", size=" + size
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PassengerCar car = (PassengerCar) o;
        return id == car.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, size);
    }
}
