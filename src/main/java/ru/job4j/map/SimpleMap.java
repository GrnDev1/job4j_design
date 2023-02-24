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
        int i = indexFor(hash(getHashcode(key)));
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

    private int getHashcode(K key) {
        int hashcode = key == null ? 0 : key.hashCode();
        return hashcode;
    }

    private int hash(int hashCode) {
        int result = 0;
        if (hashCode != 0) {
            result = hashCode ^ hashCode >>> 16;
        }
        return result;
    }

    private int indexFor(int hash) {
        return (capacity - 1) & hash;
    }

    private void expand() {
        capacity *= 2;
        MapEntry<K, V>[] temp = new MapEntry[capacity];
        for (MapEntry<K, V> i : table) {
            if (i != null) {
                int index = indexFor(hash(getHashcode(i.key)));
                if (temp[index] == null) {
                    temp[index] = new MapEntry<>(i.key, i.value);
                }
            }
        }
        table = temp;
    }

    @Override
    public V get(K key) {
        V result = null;
        MapEntry<K, V> temp = table[indexFor(hash(getHashcode(key)))];
        if (temp != null && hash(getHashcode(key)) == hash(getHashcode(temp.key)) && Objects.equals(temp.key, key)) {
            result = temp.value;
        }
        return result;
    }

    @Override
    public boolean remove(K key) {
        boolean result = false;
        int index = indexFor(hash(getHashcode(key)));
        MapEntry<K, V> temp = table[index];
        if (temp != null && hash(getHashcode(key)) == hash(getHashcode(temp.key)) && Objects.equals(temp.key, key)) {
            table[index] = null;
            result = true;
            count--;
            modCount++;
        }
        return result;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            int index;
            int counter;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (counter < table.length && table[counter] == null) {
                    counter++;
                }
                return index < count;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                index++;
                return table[counter++].key;
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