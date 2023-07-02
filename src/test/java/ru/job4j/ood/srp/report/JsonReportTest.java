package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.*;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.*;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class JsonReportTest {
    @Test
    public void whenGenerateJson() {
        Store store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Roman", now, now, 200);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker1);
        store.add(worker2);
        String expectTime = parser.parse(now);
        Report engine = new JsonReport(store, parser);
        String expect = String.format(
                "[{"
                        + "\"name\":\"%s\","
                        + "\"hired\":\"%s\","
                        + "\"fired\":\"%s\","
                        + "\"salary\":%s"
                        + "},"
                        + "{"
                        + "\"name\":\"%s\","
                        + "\"hired\":\"%s\","
                        + "\"fired\":\"%s\","
                        + "\"salary\":%s"
                        + "}]", worker1.getName(), expectTime, expectTime, worker1.getSalary(),
                worker2.getName(), expectTime, expectTime, worker2.getSalary());
        assertThat(engine.generate(e -> true)).isEqualTo(expect);
    }
}