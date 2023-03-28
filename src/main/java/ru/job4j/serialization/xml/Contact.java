package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Contact")
public class Contact {
    @XmlAttribute
    private String phone;

    @XmlAttribute
    private double salary;

    public Contact() {

    }

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