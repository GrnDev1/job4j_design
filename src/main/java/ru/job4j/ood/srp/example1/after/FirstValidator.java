package ru.job4j.ood.srp.example1.after;

public class FirstValidator implements Validator {
    @Override
    public boolean validate(User user) {
        return user.getPassword().length() > 6;
    }
}
