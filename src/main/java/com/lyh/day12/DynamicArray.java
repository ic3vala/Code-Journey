package com.lyh.day12;

public class DynamicArray<T> {
    private Object[] elements; // java数组不支持泛型，所以使用Object[]
    private int size; // 表示 数组中实际数量
    private int capacity; // 表示 数组的容量

    public DynamicArray() {
        this.capacity = 10;
        this.elements = new Object[capacity];
        this.size = 0;
    }
    public DynamicArray(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        this.capacity = initialCapacity;
        this.elements = new Object[capacity];
        this.size = 0;
    }

    public void add(T element){
        if (size == capacity) {
            capacity *= 2;
            Object[] newElements = new Object[capacity];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;

        }
        elements[size] = element;
        size++;
    }

    public void remove(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[size - 1] = null;
        size--;

    }

    public T get(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) elements[index];
    }

    public int size(){
        return size;
    }
}
