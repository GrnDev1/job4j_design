package ru.job4j.ood.srp.example3.after;

import ru.job4j.ood.srp.example3.before.Employee;

public class PayOperations {
    private AccountDepartment accountDepartment;
    private HRDepartment hrDepartment;
    private Storage storage;

    public PayOperations(AccountDepartment accountDepartment, HRDepartment hrDepartment, Storage storage) {
        this.accountDepartment = accountDepartment;
        this.hrDepartment = hrDepartment;
        this.storage = storage;
    }

    public double calculatePay(Employee employee) {
        return accountDepartment.calculatePay(employee);
    }

    public int reportHours(Employee employee) {
        return hrDepartment.reportHours(employee);
    }

    public void save(Employee employee) {
        storage.save(employee);
    }
}