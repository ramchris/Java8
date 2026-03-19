package com.company.collections;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleListTest {

    @Test
    void addAndGetWorksForInsertedElements() {
        SimpleList<String> list = new SimpleList<>();

        list.add(0, "A");
        list.add(1, "B");
        list.add(2, "C");

        assertEquals(3, list.size());
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
    }

    @Test
    void addAtMiddleShiftsElementsRight() {
        SimpleList<String> list = new SimpleList<>();

        list.add(0, "A");
        list.add(1, "C");
        list.add(1, "B");

        assertEquals(3, list.size());
        assertEquals(Arrays.asList("A", "B", "C"), Arrays.asList(list.get(0), list.get(1), list.get(2)));
    }

    @Test
    void removeReturnsRemovedElementAndShiftsLeft() {
        SimpleList<String> list = new SimpleList<>();

        list.add(0, "A");
        list.add(1, "B");
        list.add(2, "C");

        String removed = list.remove(1);

        assertEquals("B", removed);
        assertEquals(2, list.size());
        assertEquals("A", list.get(0));
        assertEquals("C", list.get(1));
    }

    @Test
    void supportsGrowthBeyondInitialCapacity() {
        SimpleList<Integer> list = new SimpleList<>();

        for (int i = 0; i < 15; i++) {
            list.add(i, i);
        }

        assertEquals(15, list.size());
        assertEquals(0, list.get(0));
        assertEquals(14, list.get(14));
    }

    @Test
    void getThrowsOnInvalidIndex() {
        SimpleList<String> list = new SimpleList<>();

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));

        list.add(0, "A");
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }

    @Test
    void addThrowsOnInvalidIndex() {
        SimpleList<String> list = new SimpleList<>();

        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, "X"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(1, "X"));
    }

    @Test
    void removeThrowsOnInvalidIndex() {
        SimpleList<String> list = new SimpleList<>();

        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));

        list.add(0, "A");
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
    }
}
