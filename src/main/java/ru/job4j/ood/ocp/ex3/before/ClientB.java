package ru.job4j.ood.ocp.ex3.before;

public class ClientB implements Client {
    @Override
    public void pay() {
        System.out.println("Client A");
    }
}
