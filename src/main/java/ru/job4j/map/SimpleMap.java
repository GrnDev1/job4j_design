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
        boolean result = false;
        int index = getIndex(key);
        if (table[index] == null) {
            table[index] = new MapEntry<>(key, value);
            result = true;
            count++;
            modCount++;
        }
        if (count >= capacity * LOAD_FACTOR) {
            expand();
        }
        return result;
    }

    private int getIndex(K key) {
        return indexFor(hash(Objects.hashCode(key)));
    }

    private int hash(int hashCode) {
        return hashCode ^ hashCode >>> 16;
    }

    private int indexFor(int hash) {
        return (capacity - 1) & hash;
    }

    private void expand() {
        capacity *= 2;
        MapEntry<K, V>[] temp = new MapEntry[capacity];
        for (MapEntry<K, V> i : table) {
            if (i != null) {
                temp[getIndex(i.key)] = i;
            }
        }
        table = temp;
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        return isEquals(key, index) ? table[index].value : null;
    }

    @Override
    public boolean remove(K key) {
        boolean result = false;
        int index = getIndex(key);
        if (isEquals(key, index)) {
            table[index] = null;
            result = true;
            count--;
            modCount++;
        }
        return result;
    }

    private boolean isEquals(K key, int index) {
        MapEntry<K, V> temp = table[index];
        return temp != null && Objects.hashCode(key) == Objects.hashCode(temp.key) && Objects.equals(temp.key, key);
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
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
                return counter < table.length;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
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