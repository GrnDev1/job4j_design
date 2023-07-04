package ru.job4j.ood.lsp.productstorage;

import java.time.LocalDateTime;

public class Cheese extends Food {
    public Cheese(String name, LocalDateTime expiryDate, LocalDateTime createDate, double price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
