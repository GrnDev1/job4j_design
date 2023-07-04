package ru.job4j.ood.lsp.productstorage;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class PercentCounter {
    private Food food;
    private LocalDateTime date;

    public PercentCounter(Food food, LocalDateTime date) {
        this.food = food;
        this.date = date;
    }

    public Food setPercent() {
        LocalDateTime expiryDate = food.getExpiryDate();
        LocalDateTime createDate = food.getCreateDate();
        long diffNowCreateDate = ChronoUnit.MINUTES.between(createDate, date);
        long diffExpiryDateCreateDate = ChronoUnit.MINUTES.between(createDate, expiryDate);
        food.setExpiryPercent(diffNowCreateDate * 100.0 / diffExpiryDateCreateDate);
        return food;
    }
}