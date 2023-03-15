package ru.job4j.io.duplicates;


import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private Map<FileProperty, String> map = new HashMap<>();
    private Set<FileProperty> set = new HashSet<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        long size = file.toFile().length();
        String name = file.toFile().getName();
        FileProperty temp = new FileProperty(size, name);
        if (map.containsKey(temp)) {
            map.put(temp, map.get(temp) + System.lineSeparator() + file.toFile().getAbsolutePath());
            set.add(temp);
        } else {
            map.put(temp, name + " - " + size + " bytes" + System.lineSeparator() + file.toAbsolutePath());
        }
        return super.visitFile(file, attrs);
    }

    public void getDublicates() {
        for (FileProperty fileProperty : set) {
            System.out.println(map.get(fileProperty));
        }
    }
}