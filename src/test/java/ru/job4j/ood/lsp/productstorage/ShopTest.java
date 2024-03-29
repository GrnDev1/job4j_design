package ru.job4j.ood.lsp.productstorage;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ShopTest {
    LocalDateTime time = LocalDateTime.of(2023, Month.JULY, 4, 17, 20);
    Store wareHouse = new Warehouse(time);
    Store shop = new Shop(time);
    Store trash = new Trash(time);

    @Test
    public void whenAddInShopBetween25And75() {

        List<Store> list = List.of(wareHouse, shop, trash);
        ControlQuality controlQuality = new ControlQuality(list);
        Cheese cheese = new Cheese("Riccota", LocalDateTime.of(2023, Month.JULY, 10, 17, 10), LocalDateTime.of(2023, Month.JULY, 1, 10, 20), 500.0, 30);
        controlQuality.allocate(cheese);
        assertThat(shop.findAll().get(0)).isEqualTo(cheese);
    }

    @Test
    public void whenAddInShopMore75() {
        List<Store> list = List.of(wareHouse, shop, trash);
        ControlQuality controlQuality = new ControlQuality(list);
        Cheese cheese = new Cheese("Riccota", LocalDateTime.of(2023, Month.JULY, 5, 17, 10), LocalDateTime.of(2023, Month.JULY, 1, 10, 20), 500.0, 10);
        controlQuality.allocate(cheese);
        assertThat(shop.findAll().get(0).getPrice()).isEqualTo(450);
    }
}