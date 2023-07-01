package ru.job4j.ood.ocp.ex2.before;

public class DataBaseStore implements Store {

    @Override
    public void save() {
        System.out.println("Сохраняю в DB");
    }
}
