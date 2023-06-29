package ru.job4j.ood.srp.example1.before;

public class User {
    private String login;
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public boolean validate() {
        return password.length() > 6;
    }

    public boolean validate(Messenger messenger) {
        return password.length() > 8;
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
        User user = new User("myLogin", "myPassword");
        System.out.println(user.validate());
    }
}
