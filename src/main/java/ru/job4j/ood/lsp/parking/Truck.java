package ru.job4j.ood.lsp.parking;

import java.util.Objects;

public class Truck extends PassengerCar implements Car {
    private int size = 2;

    public Truck() {
    }

    public Truck(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Truck{"
                + "id=" + super.id
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
        if (!super.equals(o)) {
            return false;
        }
        Truck truck = (Truck) o;
        return id == truck.id && size == truck.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, size);
    }
}
