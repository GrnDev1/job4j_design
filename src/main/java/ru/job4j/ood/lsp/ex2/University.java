package ru.job4j.ood.lsp.ex2;

import ru.job4j.ood.lsp.ex1.*;

import java.util.List;

public class University {
    protected List<Employee> list;

    public void getEmployee(Employee e) {
        if (e.getSalary() > 200) {
            list.add(e);
        }
    }
}
