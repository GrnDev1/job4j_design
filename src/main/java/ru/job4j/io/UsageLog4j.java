package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        byte kids = 2;
        short age = 33;
        int weight = 70;
        long friends = 100L;
        float money = 1000F;
        double students = 3500;
        boolean married = true;
        char nameLetter = 'P';
        LOG.debug("User info first name letter : {}, age : {}, weight : {}, friends : {}, married : {}, kids : {}, money : {}, students : {}", nameLetter, age, weight, friends, married, kids, money, students);
    }
}