package ru.job4j.io;

import java.io.*;
import java.util.*;

public class CSVReader {
    public static void handle(ArgsName argsName) {
        StringBuilder builder = new StringBuilder();
        String out = argsName.get("out");
        String delimiter = argsName.get("delimiter");
        String[] filters = argsName.get("filter").split(",");
        Integer[] indexes = new Integer[filters.length];
        Map<String, Integer> map = new HashMap<>();
        try (Scanner scanner = new Scanner(new FileReader(argsName.get("path")))) {
            if (scanner.hasNextLine()) {
                String[] headers = scanner.nextLine().split(delimiter);
                for (int i = 0; i < headers.length; i++) {
                    map.put(headers[i], i);
                }
                for (int j = 0; j < filters.length; j++) {
                    String temp = filters[j];
                    indexes[j] = map.get(temp);
                    if (j == filters.length - 1) {
                        builder.append(temp);
                        break;
                    }
                    builder.append(temp + delimiter);
                }
                builder.append(System.lineSeparator());
            }
            while (scanner.hasNextLine()) {
                String[] tempLine = scanner.nextLine().split(delimiter);
                for (int i = 0; i < indexes.length; i++) {
                    String temp = tempLine[indexes[i]];
                    if (i == filters.length - 1) {
                        builder.append(temp);
                        break;
                    }
                    builder.append(temp + delimiter);
                }
                builder.append(System.lineSeparator());
            }
            if ("stdout".equals(out)) {
                System.out.print(builder);
            } else {
                try (PrintWriter writer = new PrintWriter(out)) {
                    writer.print(builder);
                }
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
        if (!"stdout".equals(output) && (output.length() < 5 || !output.endsWith(".csv"))) {
            throw new IllegalArgumentException("Invalid output name");
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
