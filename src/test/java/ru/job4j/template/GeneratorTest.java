package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

@Disabled
class GeneratorTest {
    Generator generator = (template, args) -> null;
    String template = "I am a ${name}, Who are ${subject}? ";
    Map<String, String> map = new HashMap<>();

    @Test
    public void whenKeyInTemplateAreNotInMap() {
        assertThatThrownBy(() -> generator.produce(template, map)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessage("There are keys in the template that are not in map");
    }

    @Test
    public void whenMapContainsUnnecessaryKeys() {
        assertThatThrownBy(() -> generator.produce(template, map)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessage("Map contains unnecessary keys");
    }

    @Test
    public void whenGenerationSuccessful() {
        String result = "I am a Petr Arsentev, Who are you? ";
        assertThat(generator.produce(template, map)).isEqualTo(result);
    }
}