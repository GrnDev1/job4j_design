package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
@Disabled
class CarParkingTest {
    @Test
    public void whenAddCarsSuccessfully() {
        Car scania = new Truck();
        Car mazda = new PassengerCar();
        Parking parking = new CarParking(3, 4);
        parking.add(scania);
        parking.add(mazda);
        List<Car> expected = List.of(scania, mazda);
        assertThat(parking.findAll()).isEqualTo(expected);
    }

    @Test
    public void whenAddTruckIsTrue() {
        Car scania = new Truck();
        Parking parking = new CarParking(1, 0);
        assertThat(parking.add(scania)).isTrue();
    }

    @Test
    public void whenAddTruckInPassengerPlace() {
        Car scania = new Truck(3);
        Parking parking = new CarParking(0, 3);
        assertThat(parking.add(scania)).isTrue();
    }

    @Test
    public void whenAddTruckIsFalse() {
        Car scania = new Truck(3);
        Parking parking = new CarParking(0, 2);
        assertThat(parking.add(scania)).isFalse();
    }

    @Test
    public void whenAddPassengerCarIsFalse() {
        Parking parking = new CarParking(1, 3);
        parking.add(new Truck());
        parking.add(new PassengerCar());
        parking.add(new Truck());
        assertThat(parking.add(new PassengerCar())).isFalse();
    }
}