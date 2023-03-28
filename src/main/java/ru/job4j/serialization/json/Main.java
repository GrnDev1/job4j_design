package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;

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
        System.out.println();
        /* JSONObject напрямую методом put */
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sex", person.isSex());
        jsonObject.put("age", person.getAge());
        Contact temp = person.getContact();
        JSONObject jsonContact = new JSONObject(String.format("{\"phone\":\"%s\",\"salary\":%s}", temp.getPhone(), temp.getSalary()));
        jsonObject.put("contact", jsonContact);
        jsonObject.put("statuses", person.getStatuses());
        System.out.println(jsonObject.toString());
        /* Преобразуем объект person в json-строку */
        System.out.println(new JSONObject(person).toString());

    }
}