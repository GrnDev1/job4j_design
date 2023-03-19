package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> log = new ArrayList<>();
        List<String> botList = readPhrases();
        String message = "Приложение запущено:";
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        boolean mod = true;
        System.out.println(message);
        log.add(message);
        while (flag) {
            System.out.print("User: ");
            message = scanner.nextLine();
            log.add("User: " + message);
            if (OUT.equals(message)) {
                flag = false;
                mod = false;
            }
            if (STOP.equals(message)) {
                mod = false;
                continue;
            }
            if (CONTINUE.equals(message)) {
                mod = true;
            }
            if (mod) {
                String temp = "ChatBot: " + botList.get((int) (Math.random() * botList.size()));
                log.add(temp);
                System.out.println(temp);
            }
        }
        this.saveLog(log);
    }

    private List<String> readPhrases() {
        List<String> botList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(botAnswers))) {
            reader.lines().forEach(botList::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return botList;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter writer = new PrintWriter(path)) {
            for (String s : log) {
                writer.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("data/chat.txt", "data/answers.txt");
        cc.run();
    }
}