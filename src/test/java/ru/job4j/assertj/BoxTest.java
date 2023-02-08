package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 12);
        String name = box.whatsThis();
        assertThat(name).containsIgnoringCase("cube")
                .isEqualTo("Cube");
    }

    @Test
    void whenCubeNumberOfVerticesThen8() {
        Box box = new Box(8, 12);
        int vertex = box.getNumberOfVertices();
        assertThat(vertex).isGreaterThan(7)
                .isEqualTo(8);
    }

    @Test
    void whenUnknownNumberOfVerticesThenMinus1() {
        Box box = new Box(3, 3);
        int vertex = box.getNumberOfVertices();
        assertThat(vertex).isLessThan(0)
                .isEqualTo(-1);
    }

    @Test
    void whenUnknownIsNotExist() {
        Box box = new Box(3, 3);
        boolean result = box.isExist();
        assertThat(result).isFalse()
                .isEqualTo(false);
    }

    @Test
    void whenTetrahedronGetAreaThen62dot35() {
        Box box = new Box(4, 6);
        double result = box.getArea();
        assertThat(result).isEqualTo(62.35, withPrecision(0.01))
                .isGreaterThan(62.35);
    }

    @Test
    void whenUnknownGetAreaThen0() {
        Box box = new Box(1, 0);
        double result = box.getArea();
        assertThat(result).isZero()
                .isEqualTo(0);
    }
}