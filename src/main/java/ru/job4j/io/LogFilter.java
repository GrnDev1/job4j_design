package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> list = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            in.lines()
                    .filter(s -> {
                        String[] array = s.split(" ");
                        return "404".equals(array[array.length - 2]);
                    })
                    .forEach(list::add);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(file)) {
            for (String s : log) {
                out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> log = filter("data/log.txt");
        log.forEach(System.out::println);
        save(log, "data/404.txt");
    }
}