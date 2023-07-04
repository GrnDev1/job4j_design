package ru.job4j.ood.lsp.productstorage;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {
    final static int FISRT = 0;
    final static int SECOND  = 25;
    final static int THIRD = 50;
    final static int FOURTH = 75;
    final static int FIFTH = 100;
    private List<Food> list = new ArrayList<>();

    abstract boolean validate(Food food);

    public boolean add(Food food) {
        boolean result = false;
        if (validate(food)) {
            list.add(food);
            result = true;
        }
        return result;
    }

    public List<Food> findAll() {
        return new ArrayList<>(list);
    }
}
