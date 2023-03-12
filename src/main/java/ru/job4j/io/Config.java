package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {

    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader out = new BufferedReader(new FileReader(path))) {
            out.lines()
                    .filter(s -> !s.startsWith("#") && s.contains("="))
                    .forEach(s -> {
                        String[] array = s.split("=", 2);
                        values.put(array[0], array[1]);
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        String result = values.get(key);
        if (!values.containsKey(key) || "".equals(key) || "".equals(result)) {
            throw new IllegalArgumentException();
        }
        return result;
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("data/app.properties"));

    }
}