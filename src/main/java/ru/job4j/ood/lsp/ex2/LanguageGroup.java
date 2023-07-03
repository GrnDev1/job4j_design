package ru.job4j.ood.lsp.ex2;

import ru.job4j.ood.lsp.ex1.*;

public class LanguageGroup extends University {
    private double sumSalary;

    @Override
    public void getEmployee(Employee e) {
        sumSalary += e.getSalary();
        list.add(e);
    }
}
