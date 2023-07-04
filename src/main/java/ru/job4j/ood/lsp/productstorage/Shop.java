package ru.job4j.ood.lsp.productstorage;

public class Shop extends AbstractStore {
    @Override
    boolean validate(Food food) {
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
