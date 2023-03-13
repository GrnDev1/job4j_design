package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(target)) {
            String flag = null;
            String added;
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                boolean startsWith = line.startsWith("5") || line.startsWith("4");
                added = line.split(" ")[1];
                if (startsWith && flag == null) {
                    flag = added;
                } else if (!startsWith && flag != null) {
                    out.println(flag + ";" + added);
                    flag = null;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}