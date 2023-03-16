package ru.job4j.io;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException("This key: '" + key + "' is missing");
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        Arrays.stream(args)
                .forEach(s -> {
                    String[] array = s.split("=", 2);
                    if (array.length == 1) {
                        throw new IllegalArgumentException("Error: This argument '" + s + "' does not contain an equal sign");
                    }
                    String first = array[0];
                    String second = array[1];
                    if (!first.startsWith("-")) {
                        throw new IllegalArgumentException("Error: This argument '" + s + "' does not start with a '-' character");
                    }
                    if (first.length() < 2) {
                        throw new IllegalArgumentException("Error: This argument '" + s + "' does not contain a key");
                    }
                    if ("".equals(second)) {
                        throw new IllegalArgumentException("Error: This argument '" + s + "' does not contain a value");
                    }
                    values.put(first.substring(1), second);
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