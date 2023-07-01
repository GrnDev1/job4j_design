package ru.job4j.ood.ocp.ex1.after;

import java.util.ArrayList;
import java.util.List;

public class MemOrder implements OrderStore {
    private List<String> list = new ArrayList<>();

    @Override
    public void save() {
        list.add("Сохраняю в память");
    }
}
