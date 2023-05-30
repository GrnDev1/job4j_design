package ru.job4j.spammer;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ImportDB {

    private Properties cfg;
    private String dump;

    public ImportDB(Properties cfg, String dump) {
        this.cfg = cfg;
        this.dump = dump;
    }

    public void createTable(Connection connection) throws SQLException {
        String sql =
                "CREATE TABLE IF NOT EXISTS users ("
                        + "id SERIAL PRIMARY KEY,"
                        + "name VARCHAR(20),"
                        + "email VARCHAR(20))";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.execute();
        }
    }

    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(new FileReader(dump))) {
            rd.lines().forEach(s -> {
                String[] array = s.split(";", 2);
                validate(array, s);
                users.add(new User(array[0], array[1].substring(0, array[1].length() - 1)));
            });
        }
        return users;
    }

    private void validate(String[] array, String s) {
        if (array.length == 1) {
            throw new IllegalArgumentException(String.format("Error: This argument '%s' does not contain a semicolon sign", s));
        }
        String first = array[0];
        String second = array[1];
        if (first.length() < 2) {
            throw new IllegalArgumentException(String.format("Error: This argument '%s' does not contain name", s));
        }
        if (second.length() < 2) {
            throw new IllegalArgumentException(String.format("Error: This argument '%s' does not contain email", s));
        }
    }

    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName(cfg.getProperty("jdbc.driver"));
        try (Connection cnt = DriverManager.getConnection(
                cfg.getProperty("jdbc.url"),
                cfg.getProperty("jdbc.username"),
                cfg.getProperty("jdbc.password")
        )) {
            createTable(cnt);
            for (User user : users) {
                try (PreparedStatement ps = cnt.prepareStatement("INSERT INTO users (name, email) VALUES (?, ?)")) {
                    ps.setString(1, user.name);
                    ps.setString(2, user.email);
                    ps.execute();
                }
            }
        }
    }

    private static class User {
        String name;
        String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

    public static void main(String[] args) throws Exception {

        Properties cfg = new Properties();
        try (InputStream in = ImportDB.class.getClassLoader().getResourceAsStream("app.properties")) {
            cfg.load(in);
        }
        ImportDB db = new ImportDB(cfg, ".\\src\\main\\java\\ru\\job4j\\spammer\\dump.txt");
        db.save(db.load());
    }
}