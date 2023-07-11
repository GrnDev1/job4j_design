package ru.job4j.ood.lsp.productstorage;

import java.util.List;

public interface Store {
    boolean add(Food food);

    List<Food> findAll();

    void clear();
}
