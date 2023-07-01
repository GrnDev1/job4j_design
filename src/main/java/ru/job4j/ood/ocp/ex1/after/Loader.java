package ru.job4j.ood.ocp.ex1.after;

public class Loader {
    private OrderStore store;

    public Loader(OrderStore store) {
        store.save();
    }
}
