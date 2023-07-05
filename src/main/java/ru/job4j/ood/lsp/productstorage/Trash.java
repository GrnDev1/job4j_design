package ru.job4j.ood.lsp.productstorage;

import java.time.LocalDateTime;

public class Trash extends AbstractStore {
    private final PercentCounter percentCounter;

    public Trash(LocalDateTime time) {
        this.percentCounter = new PercentCounter(time);
    }

    @Override
    boolean validate(Food food) {
        food = percentCounter.setPercent(food);
        return food.getExpiryPercent() > FISRT;
    }
}
