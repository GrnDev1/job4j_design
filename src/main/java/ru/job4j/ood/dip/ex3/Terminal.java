package ru.job4j.ood.dip.ex3;

public class Terminal {
    double pay(double sum) {
        QiwiSystem system = new QiwiSystem();
        return system.getSum(sum) + 100;
    }
}
