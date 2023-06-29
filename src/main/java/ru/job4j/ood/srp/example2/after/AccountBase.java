package ru.job4j.ood.srp.example2.after;

import java.util.ArrayList;
import java.util.List;

public class AccountBase {
    private List<Account> accountList = new ArrayList<>();

    public void save(Account account) {
        accountList.add(account);
    }

    public Account getAccount(int id) {
        return accountList.get(id);
    }
}
