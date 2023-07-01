package ru.job4j.ood.ocp.ex1.before;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<String> list = new ArrayList<>();

    public void saveMemory() {
        list.add("Сохраняю в память");
    }
}
