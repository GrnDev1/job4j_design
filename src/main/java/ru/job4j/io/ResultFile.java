package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class ResultFile {

    public static int[][] multiple(int size) {
        int[][] array = new int[size][size];
        for (byte i = 0; i < array.length; i++) {
            for (byte j = 0; j < array.length; j++) {
                array[i][j] = (i + 1) * (j + 1);
            }
        }
        return array;
    }

    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("data/dataresult.txt")) {
            int[][] array = multiple(9);
            for (int[] temp : array) {
                for (int i : temp) {
                    out.write((i + " ").getBytes());
                }
                out.write(System.lineSeparator().getBytes());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}