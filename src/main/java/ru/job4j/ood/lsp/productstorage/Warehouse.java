package ru.job4j.ood.lsp.productstorage;

public class Warehouse extends AbstractStore {
    @Override
    boolean validate(Food food) {
        return food.getExpiryPercent() < SECOND;
    }
}
