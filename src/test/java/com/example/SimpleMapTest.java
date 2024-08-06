package com.example;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleMapTest {

    private SimpleMap<String, Integer> map;

    @BeforeEach
    public void setUp() {
        map = new SimpleMap<>();
    }

    @Test
    public void testPutAndGet() {
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        assertEquals(1, map.get("one"));
        assertEquals(2, map.get("two"));
        assertEquals(3, map.get("three"));
    }

    @Test
    public void testContainsKey() {
        map.put("one", 1);
        map.put("two", 2);

        assertTrue(map.containsKey("one"));
        assertTrue(map.containsKey("two"));
        assertFalse(map.containsKey("three"));
    }

    @Test
    public void testContainsValue() {
        map.put("one", 1);
        map.put("two", 2);

        assertTrue(map.containsValue(1));
        assertTrue(map.containsValue(2));
        assertFalse(map.containsValue(3));
    }

    @Test
    public void testSize() {
        assertEquals(0, map.size());

        map.put("one", 1);
        assertEquals(1, map.size());

        map.put("two", 2);
        assertEquals(2, map.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(map.isEmpty());

        map.put("one", 1);
        assertFalse(map.isEmpty());

        map.clear();
        assertTrue(map.isEmpty());
    }

    @Test
    public void testClear() {
        map.put("one", 1);
        map.put("two", 2);

        map.clear();

        assertEquals(0, map.size());
        assertTrue(map.isEmpty());
    }

    @Test
    public void testKeySet() {
        map.put("one", 1);
        map.put("two", 2);

        Set<String> keys = map.keySet();
        assertEquals(2, keys.size());
        assertTrue(keys.contains("one"));
        assertTrue(keys.contains("two"));
    }

    @Test
    public void testValues() {
        map.put("one", 1);
        map.put("two", 2);

        Collection<Integer> values = map.values();
        assertEquals(2, values.size());
        assertTrue(values.contains(1));
        assertTrue(values.contains(2));
    }

    @Test
    public void testEntrySet() {
        map.put("one", 1);
        map.put("two", 2);

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        assertEquals(2, entries.size());

        for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getKey().equals("one")) {
                assertEquals(1, entry.getValue());
            } else if (entry.getKey().equals("two")) {
                assertEquals(2, entry.getValue());
            }
        }
    }
}


