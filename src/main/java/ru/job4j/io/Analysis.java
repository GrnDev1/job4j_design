package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(target)) {
            StringBuilder result = new StringBuilder();
            boolean flag = false;
            String added;
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                boolean startsWith = line.startsWith("5") || line.startsWith("4");
                added = line.split(" ")[1];
                if (startsWith && !flag) {
                    flag = true;
                    result.append(added).append(";");
                } else if (!startsWith && flag) {
                    result.append(added).append(System.lineSeparator());
                    flag = false;
                }
            }
            out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}