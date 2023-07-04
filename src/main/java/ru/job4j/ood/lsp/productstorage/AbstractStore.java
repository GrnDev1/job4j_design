package ru.job4j.ood.lsp.productstorage;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {
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
