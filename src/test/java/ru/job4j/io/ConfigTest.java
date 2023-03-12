package ru.job4j.io;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ConfigTest {

    @Test
    void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Petr Arsentev");
    }

    @Test
    void whenPairWithoutIllegalArgumentException() {
        String path = "data/pair_with_exceptions.properties";
        Config config = new Config(path);
        config.load();
        assertThatThrownBy(() -> config.value("alex"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}