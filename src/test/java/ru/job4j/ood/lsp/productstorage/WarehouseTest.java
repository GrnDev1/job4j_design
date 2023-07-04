package ru.job4j.ood.lsp.productstorage;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WarehouseTest {
    @Test
    public void whenAddInWarehouse() {
        Store wareHouse = new Warehouse();
        Store shop = new Shop();
        Store trash = new Trash();
        List<Store> list = List.of(wareHouse, shop, trash);
        ControlQuality controlQuality = new ControlQuality(list);
        Cheese cheese = new Cheese("Riccota", LocalDateTime.of(2023, Month.JULY, 14, 17, 10), LocalDateTime.of(2023, Month.JULY, 1, 10, 20), 500.0, 30);
        LocalDateTime time = LocalDateTime.of(2023, Month.JULY, 4, 17, 20);
        controlQuality.allocate(new PercentCounter(cheese, time).setPercent());
        assertThat(wareHouse.findAll().get(0)).isEqualTo(cheese);
    }

}