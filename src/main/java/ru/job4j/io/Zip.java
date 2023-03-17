package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    private void validate(ArgsName name) {
        String directory = name.get("d");
        String excluded = name.get("e");
        String output = name.get("o");
        File file = new File(directory);
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (excluded.length() < 2 || !excluded.startsWith(".")) {
            throw new IllegalArgumentException("Extension does not exist");
        }
        if (output.length() < 5 || !output.endsWith(".zip")) {
            throw new IllegalArgumentException("Invalid Zip name");
        }
    }

    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path source : sources) {
                zip.putNextEntry(new ZipEntry(source.toFile().getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source.toFile()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length < 3) {
            throw new IllegalArgumentException("Add the missing arguments");
        }
        Zip zip = new Zip();
        ArgsName name = ArgsName.of(args);
        zip.validate(name);
        List<Path> pathList = Search.search(Path.of(name.get("d")), p -> !p.toFile().getName().endsWith(name.get("e")));
        zip.packFiles(pathList, new File(name.get("o")));
    }
}