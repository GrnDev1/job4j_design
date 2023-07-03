package ru.job4j.ood.lsp.ex3;

import ru.job4j.ood.lsp.ex1.Employee;

public class University {
    public double paySalary(Employee e) {
        double salary = e.getSalary();
        if (e.getWorkExperience() > 10) {
            salary *= 1.5;
        }
        return salary * 10;
    }
}
