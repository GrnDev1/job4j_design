package ru.job4j.ood.srp.report;

import com.google.gson.*;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.function.Predicate;

public class JsonReport implements Report {
    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;

    public JsonReport(Store store, DateTimeParser<Calendar> dateTimeParser) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        JsonArray jsonArray = new JsonArray();
        JsonObject jsonObject;
        for (Employee employee : store.findBy(filter)) {
            jsonObject = new JsonObject();
            jsonObject.addProperty("name", employee.getName());
            jsonObject.addProperty("hired", dateTimeParser.parse(employee.getHired()));
            jsonObject.addProperty("fired", dateTimeParser.parse(employee.getFired()));
            jsonObject.addProperty("salary", employee.getSalary());
            jsonArray.add(jsonObject);
        }
        return jsonArray.toString();
    }
}
