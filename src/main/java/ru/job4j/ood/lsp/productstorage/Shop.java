package ru.job4j.ood.lsp.productstorage;

import java.time.LocalDateTime;

public class Shop extends AbstractStore {
    private final PercentCounter percentCounter;

    public Shop(LocalDateTime time) {
        this.percentCounter = new PercentCounter(time);
    }

    @Override
    boolean validate(Food food) {
        food = percentCounter.setPercent(food);
        boolean result = false;
        double expiryPercent = food.getExpiryPercent();
        if (expiryPercent > FOURTH && expiryPercent <= FIFTH) {
            food.setPrice(food.getPrice() * (1 - food.getDiscount() / 100));
            result = true;
        } else if (expiryPercent > SECOND && expiryPercent < FOURTH) {
            result = true;
        }
        return result;
    }
}
