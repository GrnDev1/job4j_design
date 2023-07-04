package ru.job4j.ood.lsp.productstorage;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Trash extends AbstractStore {
    @Override
    boolean validate(Food food) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expiryDate = food.getExpiryDate();
        long diff = ChronoUnit.MINUTES.between(expiryDate, now);
        return diff > 0;
    }
}
