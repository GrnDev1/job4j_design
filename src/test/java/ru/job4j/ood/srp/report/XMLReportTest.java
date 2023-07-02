package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.*;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.*;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class XMLReportTest {
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
        Report engine = new XMLReport(store, parser);
        StringBuilder expect = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n")
                .append("<employees>\n")
                .append("    <employee>\n")
                .append("        <name>" + worker1.getName() + "</name>").append("\n")
                .append("        <hired>" + expectTime + "</hired>").append("\n")
                .append("        <fired>" + expectTime + "</fired>").append("\n")
                .append("        <salary>" + worker1.getSalary() + "</salary>").append("\n")
                .append("    </employee>\n")
                .append("    <employee>\n")
                .append("        <name>" + worker2.getName() + "</name>").append("\n")
                .append("        <hired>" + expectTime + "</hired>").append("\n")
                .append("        <fired>" + expectTime + "</fired>").append("\n")
                .append("        <salary>" + worker2.getSalary() + "</salary>").append("\n")
                .append("    </employee>\n")
                .append("</employees>\n");
        assertThat(engine.generate(e -> true)).isEqualTo(expect.toString());
    }
}