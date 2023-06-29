package ru.job4j.ood.srp.example3.after;

import ru.job4j.ood.srp.example3.before.Employee;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private List<Employee> list = new ArrayList<>();

    public void save(Employee employee) {
        list.add(employee);
    }
}
