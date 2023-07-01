package ru.job4j.ood.ocp.ex3.after;

import ru.job4j.ood.ocp.ex3.before.*;

import java.util.List;

public class ServiceQueue extends Service {
    @Override
    public void install(List<Client> list) {
        System.out.println("Сначала собираем клиентов A...");
        for (Client client : list) {
            client.pay();
        }
    }
}
