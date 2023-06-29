package ru.job4j.ood.srp.example1.after;

public class User {
    private Validator validator;
    private String login;
    private String password;

    public User() {
        this.validator = new FirstValidator();
    }

    public User(Validator validator) {
        this.validator = validator;
    }

    public boolean validate() {
        return validator.validate(this);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void main(String[] args) {
        User user = new User(new SecondValidator());
        user.setLogin("myLogin");
        user.setPassword("myPassword");
        user.validate();
    }
}
