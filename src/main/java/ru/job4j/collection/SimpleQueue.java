package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    int count;
    int outCount;

    public T poll() {
        if (count < 1 && outCount < 1) {
            throw new NoSuchElementException();
        }
        if (outCount == 0) {
            while (count > 0) {
                out.push(in.pop());
                count--;
                outCount++;
            }
        }
        outCount--;
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
        count++;
    }
}