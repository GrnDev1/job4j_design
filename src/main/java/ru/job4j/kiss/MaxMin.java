package ru.job4j.kiss;

import java.util.*;

public class MaxMin {

    private <T> T get(List<T> value, Comparator<T> comparator) {
        value.sort(comparator);
        return value.get(value.size() - 1);
    }

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return get(value, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return get(value, comparator.reversed());
    }
}