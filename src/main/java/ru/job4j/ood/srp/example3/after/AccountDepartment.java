package ru.job4j.ood.srp.example3.after;

import ru.job4j.ood.srp.example3.before.Employee;

public class AccountDepartment {
    private int getHours(Employee employee) {
        return employee.getWorkHours() - 3;
    }

    public double calculatePay(Employee employee) {
        return (getHours(employee) - 0.5) * 100;
    }
}
