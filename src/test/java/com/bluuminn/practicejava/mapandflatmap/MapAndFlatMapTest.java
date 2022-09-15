package com.bluuminn.practicejava.mapandflatmap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapAndFlatMapTest {
    List<List<String>> list;

    @BeforeEach
    void setUp() {
        list = Arrays.asList(
                List.of("a"),
                List.of("b"));
    }

    @Test
    void mapInOptional() {
        Optional<String> s = Optional.of("test");
        assertEquals(Optional.of("TEST"), s.map(String::toUpperCase));
    }

    @Test
    void nestedOptionalString() {
        Optional<Optional<String>> nestedOptionalString1 = Optional.of(Optional.of("STRING"));
        Optional<Optional<String>> nestedOptionalString2 = Optional.of("string").map(s -> Optional.of("STRING"));
        System.out.println(nestedOptionalString1);
        System.out.println(nestedOptionalString2);
        assertEquals(nestedOptionalString1, nestedOptionalString2);
    }

    @Test
    void flatMapInOptional() {
        Optional<String> flatMapString = Optional.of("string").flatMap(s -> Optional.of("STRING"));
        System.out.println(flatMapString);
        assertEquals(Optional.of("STRING"), flatMapString);
    }

    @Test
    void mapInStream() {
        System.out.println(list);
    }

    @Test
    void flatMapInStream() {
        List<String> flatMapList = list
                .stream()
                .flatMap(Collection::stream)
                .toList();
        System.out.println(flatMapList);
    }
}
