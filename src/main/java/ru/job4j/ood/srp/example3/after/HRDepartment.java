package ru.job4j.ood.srp.example3.after;

import ru.job4j.ood.srp.example3.before.Employee;

public class HRDepartment {
    private int getHours(Employee employee) {
        return employee.getWorkHours() - 4;
    }

    public int reportHours(Employee employee) {
        return getHours(employee) - 1;
    }
}
