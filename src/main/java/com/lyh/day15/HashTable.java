package com.lyh.day15;


import java.util.LinkedList;

public class HashTable<K, V> {

    private LinkedList<Entry<K, V>>[] buckets; //数组
    private int size;
    static class Entry<K, V> {
        K key;
        V value;
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashTable(int capacity ) {
        this.size = capacity;
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }

    }

    private int Hash(K key) {
        return Math.abs(key.hashCode() % size);
    }

    public void put(K key, V value) {
        int index = Hash(key);
        LinkedList<Entry<K, V>> bucket = buckets[index]; // 给数组每个元素新建链表对象
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }

        }
        bucket.add(new Entry<>(key, value));

    }
    public V get(K key) {
        int index = Hash(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value; // 找到键，返回值
            }
        }
        return null; // 未找到
    }

    public void remove(K key) {
        int index = Hash(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                bucket.remove(entry); // 删除节点
                return;
            }
        }
    }

}

