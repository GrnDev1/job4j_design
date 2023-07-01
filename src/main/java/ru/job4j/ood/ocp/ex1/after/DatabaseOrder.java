package ru.job4j.ood.ocp.ex1.after;

public class DatabaseOrder implements OrderStore {
    @Override
    public void save() {
        System.out.println("Сохраняю в базу данных...");
    }
}
