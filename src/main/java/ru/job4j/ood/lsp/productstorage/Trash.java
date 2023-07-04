package ru.job4j.ood.lsp.productstorage;

public class Trash extends AbstractStore {
    @Override
    boolean validate(Food food) {
        return food.getExpiryPercent() > FISRT;
    }
}
