package ru.job4j.ood.ocp.ex2.before;

public class Loger {
    void log(Store store) {
        if (store instanceof MemStore) {
            System.out.println("Выполняю одни действия");
        } else if (store instanceof DataBaseStore) {
            System.out.println("Выполняю другие действия");
        }
    }
}
