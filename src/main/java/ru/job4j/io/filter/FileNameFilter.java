package ru.job4j.io.filter;

import ru.job4j.io.*;

import java.io.*;
import java.nio.file.Path;
import java.util.*;

public class FileNameFilter {

    String fileType;
    String fileName;

    private void validate(ArgsName name) {
        String directory = name.get("d");
        fileName = name.get("n");
        String output = name.get("o");
        fileType = name.get("t");
        typeIsMask();
        File file = new File(directory);
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!("name".equals(fileType) || "mask".equals(fileType) || "regex".equals(fileType))) {
            throw new IllegalArgumentException("Invalid search type. "
                    + "The following options are available: name, mask, regex.");
        }
        if (output.length() < 5 || !output.endsWith(".txt")) {
            throw new IllegalArgumentException("Invalid output filename");
        }
    }

    private void typeIsMask() {
        if ("mask".equals(fileType)) {
            fileName = fileName.replace("*", "\\w*")
                    .replace(".", "\\.")
                    .replace("?", ".?");
        }
    }

    private void writeFiles(List<Path> pathList, String output) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(output))) {
            pathList.forEach(s -> writer.println(s.toFile().getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean filterFileType(Path p) {
        String tempPath = p.toFile().getName();
        boolean result;
        if ("name".equals(fileType)) {
            result = tempPath.equals(fileName);
        } else {
            result = tempPath.matches(fileName);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        if (args.length < 4) {
            throw new IllegalArgumentException("Add the missing arguments");
        }
        FileNameFilter fileNameFilter = new FileNameFilter();
        ArgsName name = ArgsName.of(args);
        fileNameFilter.validate(name);
        List<Path> pathList = Search.search(Path.of(name.get("d")), fileNameFilter::filterFileType);
        fileNameFilter.writeFiles(pathList, name.get("o"));
    }
}
