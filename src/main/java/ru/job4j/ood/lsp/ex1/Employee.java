package ru.job4j.ood.lsp.ex1;

public class Employee {
    private String name;
    private double salary;
    private int workExperience;

    public Employee(String name, double salary, int workExperience) {
        this.name = name;
        this.salary = salary;
        this.workExperience = workExperience;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
