package ru.job4j.ood.ocp.ex2.after;

public class MemLoger<MemStore> implements Loger<MemStore> {
    @Override
    public void log(MemStore store) {
        System.out.println("Выполняю действия для MemStore");
    }
}
