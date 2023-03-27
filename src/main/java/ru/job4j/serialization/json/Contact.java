package ru.job4j.serialization.json;

public class Contact {
    private final String phone;
    private final double salary;

    public Contact(String phone, double salary) {
        this.phone = phone;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Contact{"
                + "phone='" + phone + '\''
                + ", salary=" + salary + '\''
                + '}';
    }
}