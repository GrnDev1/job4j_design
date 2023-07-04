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
        controlQuality.allocate(cheese);
        assertThat(wareHouse.findAll().get(0)).isEqualTo(cheese);
    }

}