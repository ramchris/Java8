package com.company.collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SimpleHashMapTest {

    @Test
    void put() {
        SimpleHashMap<String, Integer> map = new SimpleHashMap<>();

        map.put("one", 1);
        map.put("two", 2);

        assertEquals(1, map.get("one"));
        assertEquals(2, map.get("two"));
    }

    @Test
    void get() {
        SimpleHashMap<String, String> map = new SimpleHashMap<>();

        map.put("name", "Alice");

        assertEquals("Alice", map.get("name"));
        assertNull(map.get("missing"));
    }

    @Test
    void putUpdatesExistingKey() {
        SimpleHashMap<String, String> map = new SimpleHashMap<>();

        map.put("key", "first");
        map.put("key", "second");

        assertEquals("second", map.get("key"));
    }

    @Test
    void handlesHashCollisions() {
        SimpleHashMap<CollisionKey, String> map = new SimpleHashMap<>();

        CollisionKey first = new CollisionKey("first");
        CollisionKey second = new CollisionKey("second");
        CollisionKey third = new CollisionKey("third");

        map.put(first, "value1");
        map.put(second, "value2");
        map.put(third, "value3");

        System.out.println(map.get(first));
        System.out.println(first.hashCode());
        System.out.println(first.equals(second));
        System.out.println(map.get(second));
        System.out.println(second.hashCode());
        System.out.println(map.get(third));
        System.out.println(third.hashCode());


        assertEquals("value1", map.get(first));
        assertEquals("value2", map.get(second));
        assertEquals("value3", map.get(third));
    }

    private static class CollisionKey {
        private final String value;

        private CollisionKey(String value) {
            this.value = value;
        }

        @Override
        public int hashCode() {
            return 1; // force collision
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof CollisionKey)) return false;
            CollisionKey other = (CollisionKey) obj;
            return value.equals(other.value);
        }
    }
}