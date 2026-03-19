package com.company.collections;

import java.util.AbstractList;
import java.util.Arrays;

public class SimpleList<E> extends AbstractList<E> {
    private E[] data;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public SimpleList() {
        this.data = (E[]) new Object[10]; // Initial capacity
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return data[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(int index, E element) {
        if (index > size || index < 0) throw new IndexOutOfBoundsException();

        ensureCapacity();
        // Shift elements to the right to make room
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = element;
        size++;
        modCount++; // Inherited from AbstractList to track concurrent modifications
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        E oldValue = data[index];

        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(data, index + 1, data, index, numMoved);
        }
        data[--size] = null; // Clear for GC
        return oldValue;
    }

    private void ensureCapacity() {
        if (size == data.length) {
            int newCapacity = data.length * 2;
            data = Arrays.copyOf(data, newCapacity);
        }
    }

    private void rangeCheck(int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException();
    }
}