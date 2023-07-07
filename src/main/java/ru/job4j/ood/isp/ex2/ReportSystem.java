package ru.job4j.ood.isp.ex2;

public interface ReportSystem {
    String generate(Employee employee);

    void sendReport(String report);

    byte[] sendNotification(String text);
}
