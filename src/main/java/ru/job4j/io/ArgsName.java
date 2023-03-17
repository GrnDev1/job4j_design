package ru.job4j.io;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    private void validate(String[] array, String s) {
        if (array.length == 1) {
            throw new IllegalArgumentException(String.format("Error: This argument '%s' does not contain an equal sign", s));
        }
        String first = array[0];
        String second = array[1];
        if (!first.startsWith("-")) {
            throw new IllegalArgumentException(String.format("Error: This argument '%s' does not start with a '-' character", s));
        }
        if (first.length() < 2) {
            throw new IllegalArgumentException(String.format("Error: This argument '%s' does not contain a key", s));
        }
        if ("".equals(second)) {
            throw new IllegalArgumentException(String.format("Error: This argument '%s' does not contain a value", s));
        }
    }

    public String get(String key) {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException(String.format("This key: '%s' is missing", key));
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        Arrays.stream(args)
                .forEach(s -> {
                    String[] array = s.split("=", 2);
                    validate(array, s);
                    values.put(array[0].substring(1), array[1]);
                });
    }

    public static ArgsName of(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Arguments not passed to program");
        }
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[]{"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[]{"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}