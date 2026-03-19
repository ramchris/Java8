package com.company.collections;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class SimpleHashMap<K, V>  extends AbstractMap<K,V> {
    private static class Entry<K, V> {
        K key; V value; Entry<K, V> next;
        Entry(K key, V value) { this.key = key; this.value = value; }
    }

    private Entry<K, V>[] buckets;
    private int capacity = 16;
    private int size = 0; // Track number of elements
    private final float LOAD_FACTOR = 0.75f;

    @SuppressWarnings("unchecked")
    public SimpleHashMap() {
        buckets = new Entry[capacity];
    }

    public V put(K key, V value) {
        // 1. Check if we need to grow before adding
        if (size >= capacity * LOAD_FACTOR) {
            resize();
        }

        int index = getBucketIndex(key);
        Entry<K, V> current = buckets[index];

        // 2. Standard insertion logic
        if (current == null) {
            buckets[index] = new Entry<>(key, value);
            size++;
        } else {
            while (current != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return value;
                }
                if (current.next == null) break;
                current = current.next;
            }
            current.next = new Entry<>(key, value);
            size++;
        }
        return value;
    }

    public V get(Object key) {
        int index = getBucketIndex((K) key);
        Entry<K, V> current = buckets[index];

        while (current != null) {
            if (current.key == null ? key == null : current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return Collections.emptySet();
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        capacity *= 2; // Double the capacity
        Entry<K, V>[] oldBuckets = buckets;
        buckets = new Entry[capacity];
        size = 0; // Reset size and re-add everything

        for (Entry<K, V> headNode : oldBuckets) {
            while (headNode != null) {
                put(headNode.key, headNode.value); // Re-hash into new array
                headNode = headNode.next;
            }
        }
    }

    private int getBucketIndex(K key) {
        return (key == null) ? 0 : Math.abs(key.hashCode()) % capacity;
    }
}