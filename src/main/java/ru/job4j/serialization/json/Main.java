package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        final Employee person = new Employee(false, 30, new Contact("11-111", 500),
                new String[]{"Worker", "Married"});
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(person));
        final String personJson =
                "{"
                        + "\"sex\":false,"
                        + "\"age\":30,"
                        + "\"contact\":"
                        + "{"
                        + "\"phone\":\"11-111\","
                        + "\"salary\":500.0"
                        + "},"
                        + "\"statuses\":"
                        + "[\"Worker\",\"Married\"]"
                        + "}";
        final Employee personMod = gson.fromJson(personJson, Employee.class);
        System.out.println(personMod);
    }
}