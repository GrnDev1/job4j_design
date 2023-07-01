package ru.job4j.ood.ocp.ex2.after;

public class DataBaseLoger<DataBaseStore> implements Loger<DataBaseStore> {
    @Override
    public void log(DataBaseStore store) {
        System.out.println("Выполняю действия для DataBaseStore");
    }
}