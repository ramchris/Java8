package com.company.benchmark;

import java.util.HashMap;
import java.util.Map;

public class HashMapBenchmark {
    public static void main(String[] args) {
        int count = 1_000_000;

        // 1. Default Capacity (starts at 16)
        long start1 = System.nanoTime();
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < count; i++) {
            map1.put(i, i);
        }
        long end1 = System.nanoTime();
        System.out.println("Default Map: " + (end1 - start1) / 1_000_000 + " ms");

        // 2. Pre-calculated Capacity (count / 0.75 + 1)
        long start2 = System.nanoTime();
        int initialCapacity = (int) (count / 0.75f) + 1;
        Map<Integer, Integer> map2 = new HashMap<>(initialCapacity);
        for (int i = 0; i < count; i++) {
            map2.put(i, i);
        }
        long end2 = System.nanoTime();
        System.out.println("Pre-sized Map: " + (end2 - start2) / 1_000_000 + " ms");
    }
}
