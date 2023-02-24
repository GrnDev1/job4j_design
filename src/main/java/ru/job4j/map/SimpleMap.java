package ru.job4j.map;

import java.util.*;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        int i = indexFor(hash(key));
        boolean result = false;
        if (table[i] == null) {
            table[i] = new MapEntry<>(key, value);
            result = true;
            count++;
            modCount++;
        }
        if (count / (float) capacity >= LOAD_FACTOR) {
            expand();
        }
        return result;
    }

    private int hash(Object key) {
        int result = 0;
        if (key != null) {
            result = key.hashCode() ^ key.hashCode() >>> 16;
        }
        return result;
    }

    private int indexFor(int hash) {
        return (capacity - 1) & hash;
    }

    private void expand() {
        capacity *= 2;
        table = Arrays.copyOf(table, capacity);
    }

    @Override
    public V get(K key) {
        V result = null;
        for (MapEntry<K, V> temp : table) {
            if (temp != null && hash(key) == hash(temp.key) && Objects.equals(temp.key, key)) {
                result = temp.value;
            }
        }
        return result;
    }

    @Override
    public boolean remove(K key) {
        boolean result = false;
        for (int i = 0; i < table.length; i++) {
            MapEntry<K, V> temp = table[i];
            if (temp != null && hash(key) == hash(temp.key) && Objects.equals(temp.key, key)) {
                table[i] = null;
                result = true;
                count--;
                modCount++;
            }
        }
        return result;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            int index;
            int sum;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return index < count;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                for (int temp = sum; ; temp++) {
                    if (table[temp] != null) {
                        sum = temp;
                        index++;
                        break;
                    }
                }
                return table[sum++].key;
            }
        };
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}