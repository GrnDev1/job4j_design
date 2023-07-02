package ru.job4j.ood.srp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "employees")
public class Employees {
    @XmlElement(name = "employee")
    private List<Employee> list = new ArrayList<>();

    public Employees() {

    }

    public Employees(List<Employee> list) {
        this.list = list;
    }
}
