package ru.job4j.ood.lsp.productstorage;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Shop extends AbstractStore {
    @Override
    boolean validate(Food food) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expiryDate = food.getExpiryDate();
        LocalDateTime createDate = food.getCreateDate();
        long diffNowCreateDate = ChronoUnit.MINUTES.between(createDate, now);
        long diffExpiryDateCreateDate = ChronoUnit.MINUTES.between(createDate, expiryDate);
        double ratio = diffNowCreateDate * 100.0 / diffExpiryDateCreateDate;
        if (ratio > 75 && ratio <= 100) {
            food.setPrice(food.getPrice() * (1 - food.getDiscount() / 100));
            ratio = 50;
        }
        return ratio > 25 && ratio < 75;
    }
}
