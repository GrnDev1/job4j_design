package ru.job4j.kiss;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MaxMinTest {

    Comparator<Integer> comparator = Integer::compare;
    MaxMin temp = new MaxMin();
    List<Integer> list = Arrays.asList(10, 5, 9, 55, 13, 2, 45);

    @Test
    void isMax() {
        assertThat(temp.max(list, comparator)).isEqualTo(55);
    }

    @Test
    void isMin() {
        assertThat(temp.min(list, comparator)).isEqualTo(2);
    }
}