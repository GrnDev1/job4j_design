package ru.job4j.io;

import java.io.*;
import java.util.*;

public class CSVReader {
    public static void handle(ArgsName argsName) {
        String delimiter = argsName.get("delimiter");
        String[] filters = argsName.get("filter").split(",");
        Integer[] indexes = new Integer[filters.length];
        Map<String, Integer> map = new HashMap<>();
        try (Scanner scanner = new Scanner(new FileReader(argsName.get("path")));
             PrintWriter writer = new PrintWriter(argsName.get("out"))) {
            if (scanner.hasNextLine()) {
                String[] headers = scanner.nextLine().split(delimiter);
                for (int i = 0; i < headers.length; i++) {
                    map.put(headers[i], i);
                }
                for (int j = 0; j < filters.length; j++) {
                    String temp = filters[j];
                    indexes[j] = map.get(temp);
                    if (j == filters.length - 1) {
                        writer.print(temp);
                        break;
                    }
                    writer.print(temp + delimiter);
                }
                writer.println();
            }
            while (scanner.hasNextLine()) {
                String[] tempLine = scanner.nextLine().split(delimiter);
                for (int i = 0; i < indexes.length; i++) {
                    String temp = tempLine[indexes[i]];
                    if (i == filters.length - 1) {
                        writer.print(temp);
                        break;
                    }
                    writer.print(temp + delimiter);
                }
                writer.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void validate(ArgsName name) {
        String directory = name.get("path");
        String delimiter = name.get("delimiter");
        String output = name.get("out");
        String filter = name.get("filter");
        File file = new File(directory);
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!";".equals(delimiter)) {
            throw new IllegalArgumentException("Invalid delimiter");
        }
        if (output.length() < 5 || !output.endsWith(".csv")) {
            throw new IllegalArgumentException("Invalid csv-file name");
        }
        if ("".equals(filter)) {
            throw new IllegalArgumentException("Invalid filter");
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length < 4) {
            throw new IllegalArgumentException("Add the missing arguments");
        }
        ArgsName argsName = ArgsName.of(args);
        validate(argsName);
        handle(argsName);
    }
}
