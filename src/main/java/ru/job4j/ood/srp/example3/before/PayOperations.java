package ru.job4j.ood.srp.example3.before;

import java.util.ArrayList;
import java.util.List;

public class PayOperations {
    private List<Employee> list = new ArrayList<>();

    private int getHours(Employee employee) {
        return employee.getWorkHours() - 3;
    }

    public double calculatePay(Employee employee) {
        return (getHours(employee) - 0.5) * 100;
    }

    public int reportHours(Employee employee) {
        return getHours(employee) - 1;
    }

    public void save(Employee employee) {
        list.add(employee);
    }
}
