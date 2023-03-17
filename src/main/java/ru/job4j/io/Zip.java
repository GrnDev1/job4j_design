package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    private void validate(String[] args) {
        if (args.length < 3) {
            throw new IllegalArgumentException("Add the missing arguments");
        }
        File file = new File(args[0].split("=", 2)[1]);
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
    }

    public void packFiles(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File source : sources) {
                zip.putNextEntry(new ZipEntry(source.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
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

    public List<File> getFileList(ArgsName name) throws IOException {
        List<Path> pathList = Search.search(Path.of(name.get("d")), p -> !p.toFile().getName().endsWith(name.get("e")));
        List<File> fileList = new ArrayList<>();
        for (Path path : pathList) {
            fileList.add(path.toFile());
        }
        return fileList;
    }

    public static void main(String[] args) throws IOException {
        Zip zip = new Zip();
        zip.validate(args);
        ArgsName name = ArgsName.of(args);
        List<File> fileList = zip.getFileList(name);
        zip.packFiles(fileList, new File(name.get("o")));
    }
}