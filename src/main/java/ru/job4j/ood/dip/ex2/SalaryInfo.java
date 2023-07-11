package ru.job4j.ood.dip.ex2;

public class SalaryInfo {
    public enum Employee {
        Teacher, Driver
    }

    public double recount(Employee employee) {
        double result = 0;
        if (employee.equals(Employee.Teacher)) {
            result = new Teacher().getSalary() * 1.5;
        } else if (employee.equals(Employee.Driver)) {
            result = new Driver().getSalary();
        }
        return result;
    }
}
