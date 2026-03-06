package com.company.collections;

public class SimpleHashMap<K, V> {
    // A simple container for our key-value pairs
    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next; // Pointer for the linked list (collision handling)

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Entry<K, V>[] buckets;
    private int capacity = 16; // Default starting size

    @SuppressWarnings("unchecked")
    public SimpleHashMap() {
        buckets = new Entry[capacity];
    }

    private int getBucketIndex(K key) {
        if (key == null) return 0;
        // Ensure index is positive and fits in the array
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(K key, V value) {
        int index = getBucketIndex(key);
        Entry<K, V> existing = buckets[index];

        if (existing == null) {
            buckets[index] = new Entry<>(key, value);
        } else {
            // Traverse the linked list to see if key already exists
            while (existing.next != null) {
                if (existing.key.equals(key)) {
                    existing.value = value; // Update existing key
                    return;
                }
                existing = existing.next;
            }
            // Check the last node
            if (existing.key.equals(key)) {
                existing.value = value;
            } else {
                existing.next = new Entry<>(key, value); // Add new node at the end
            }
        }
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        Entry<K, V> current = buckets[index];

        while (current != null) {
            if (current.key.equals(key)) return current.value;
            current = current.next;
        }
        return null; // Not found
    }
}
