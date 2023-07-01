package ru.job4j.ood.ocp.ex2.before;

public class MemStore implements Store {

    @Override
    public void save() {
        System.out.println("Сохраняю в Оперативную память");
    }
}
