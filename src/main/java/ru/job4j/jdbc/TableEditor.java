package ru.job4j.jdbc;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) throws Exception {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws Exception {
        if (connection == null) {
            try (InputStream in = TableEditor.class.getClassLoader().getResourceAsStream("app.properties")) {
                properties.load(in);
                String login = properties.getProperty("username");
                String password = properties.getProperty("password");
                String url = properties.getProperty("url");
                String driver = properties.getProperty("driver_class");
                Class.forName(driver);
                connection = DriverManager.getConnection(url, login, password);
            }
        }
    }

    private void getSchema(String tableName) throws Exception {
        System.out.println(getTableScheme(tableName) + "\n\n");
    }

    private void getStatement(String query) throws Exception {
        try (Statement statement = connection.createStatement()) {
            statement.execute(query);
        }
    }

    public void createTable(String tableName) throws Exception {
        String sql = String.format(
                "CREATE TABLE IF NOT EXISTS %s();",
                tableName
        );
        getStatement(sql);
        getSchema(tableName);
    }

    public void dropTable(String tableName) throws Exception {
        String sql = String.format(
                "DROP TABLE IF EXISTS %s;",
                tableName
        );
        getStatement(sql);
    }

    public void addColumn(String tableName, String columnName, String type) throws Exception {
        String sql = String.format(
                "ALTER TABLE %s\n"
                        + "ADD COLUMN %s %s;",
                tableName,
                columnName,
                type
        );
        getStatement(sql);
        getSchema(tableName);
    }

    public void dropColumn(String tableName, String columnName) throws Exception {
        String sql = String.format(
                "ALTER TABLE %s\n"
                        + "DROP COLUMN %s;",
                tableName,
                columnName
        );
        getStatement(sql);
        getSchema(tableName);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws Exception {
        String sql = String.format(
                "ALTER TABLE %s\n"
                        + "RENAME COLUMN %s TO %s;",
                tableName,
                columnName,
                newColumnName
        );
        getStatement(sql);
        getSchema(tableName);
    }

    public String getTableScheme(String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "SELECT * FROM %s LIMIT 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        TableEditor tableEditor = new TableEditor(new Properties());
        tableEditor.initConnection();
        tableEditor.createTable("students");
        tableEditor.addColumn("students", "id", "SERIAL PRIMARY KEY");
        tableEditor.addColumn("students", "\"first name\"", "TEXT");
        tableEditor.addColumn("students", "\"last name\"", "TEXT");
        tableEditor.renameColumn("students", "\"last name\"", "age");
        tableEditor.dropColumn("students", "age");
        tableEditor.dropTable("students");
        tableEditor.close();
    }
}