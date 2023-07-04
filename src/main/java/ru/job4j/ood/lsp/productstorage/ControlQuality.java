package ru.job4j.ood.lsp.productstorage;

import java.util.ArrayList;
import java.util.List;

public class ControlQuality {
    private List<Store> list = new ArrayList<>();

    public ControlQuality(List<Store> list) {
        this.list = list;
    }

    public boolean allocate(Food food) {
        boolean result = false;
        if (list.size() > 0) {
            result = true;
            for (Store store : list) {
                if (store.add(food)) {
                    break;
                }
            }
        }
        return result;
    }
}
