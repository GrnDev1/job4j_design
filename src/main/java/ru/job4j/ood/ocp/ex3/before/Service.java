package ru.job4j.ood.ocp.ex3.before;

import java.util.List;

public class Service {
    public void install(List<Client> list) {
        for (Client client : list) {
            client.pay();
        }
    }
}
