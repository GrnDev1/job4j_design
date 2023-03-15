package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        search(Path.of("./"), new DuplicatesVisitor());
    }

    public static void search(Path root, DuplicatesVisitor visitor) throws IOException {
        Files.walkFileTree(root, visitor);
        visitor.getDublicates();
    }
}