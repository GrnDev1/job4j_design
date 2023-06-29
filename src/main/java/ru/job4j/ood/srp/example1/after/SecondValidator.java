package ru.job4j.ood.srp.example1.after;

public class SecondValidator implements Validator {
    @Override
    public boolean validate(User user) {
        return user.getPassword().length() > 8;
    }
}
