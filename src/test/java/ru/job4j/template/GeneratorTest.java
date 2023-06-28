package ru.job4j.template;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

@Disabled
class GeneratorTest {
    private final Generator generator = (template, args) -> null;
    private final String template = "I am a ${name}, Who are ${subject}? ";
    private Map<String, String> map = new HashMap<>();

    @AfterEach
    public void clearMap() {
        map.clear();
    }

    @Test
    public void whenKeyInTemplateAreNotInMap() {
        map.put("name", "Petr");
        assertThatThrownBy(() -> generator.produce(template, map)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessage("There are keys in the template that are not in map");
    }

    @Test
    public void whenMapContainsUnnecessaryKeys() {
        map.put("name", "Petr");
        map.put("subject", "you");
        map.put("surname", "Arsentev");
        assertThatThrownBy(() -> generator.produce(template, map)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessage("Map contains unnecessary keys");
    }

    @Test
    public void whenGenerationSuccessful() {
        map.put("name", "Petr");
        map.put("subject", "you");
        String result = "I am a Petr Arsentev, Who are you? ";
        assertThat(generator.produce(template, map)).isEqualTo(result);
    }
}