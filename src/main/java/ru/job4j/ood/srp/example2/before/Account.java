package ru.job4j.ood.srp.example2.before;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private List<Account> accountList = new ArrayList<>();
    private String name;

    public Account(String name) {
        this.name = name;
    }

    public void save(Account account) {
        accountList.add(account);
    }

    public Account getAccount(int id) {
        return accountList.get(id);
    }
}
