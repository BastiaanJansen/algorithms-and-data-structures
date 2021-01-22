package Tables;

import java.util.*;

/**
 * In computing, a hash table (hash map) is a data structure that implements an associative array abstract data type,
 * a structure that can map keys to values. A hash table uses a hash function to compute an index, also called a hash
 * code, into an array of buckets or slots, from which the desired value can be found. During lookup,
 * the key is hashed and the resulting hash indicates where the corresponding value is stored.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Hash_table">Hash Table Wikipedia</a>
 *
 * @author Bastiaan Jansen
 * @see Table
 * @param <K> key type
 * @param <V> value type
 */
public class HashTable<K, V> implements Table<K, V> {

    private HashEntry<K, V>[] entries;
    private int currentSize;
    private final int initialSize;

    @SuppressWarnings("unchecked")
    public HashTable(int size) {
        this.entries = new HashEntry[size];
        this.currentSize = 0;
        this.initialSize = size;
    }

    private float loadFactor() {
        return (float) currentSize / entries.length;
    }

    @Override
    public void put(K key, V value) {
        HashEntry<K, V> entry = new HashEntry<>(key, value);

        if (loadFactor() > 0.7)
            resize();

        int index = bucketIndex(key);

        if (entries[index] != null) {
            if (entries[index].key.equals(key))
                entries[index] = entry;
            else {
                entry.next = entries[index].next;
                entries[index].next = entry;
                currentSize++;
            }
        }
        else {
            entries[index] = entry;
            currentSize++;
        }
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        for (K key: map.keySet())
            put(key, map.get(key));
    }

    @Override
    public void putAll(Table<K, ? extends V> table) {
        for (K key: table.keySet())
            put(key, table.get(key));
    }

    @Override
    public V get(K key) {
        int index = bucketIndex(key);
        HashEntry<K, V> entry = entries[index];
        if (entry == null)
            throw new NoSuchElementException();

        if (!entry.key.equals(key) && entry.next != null) {
            HashEntry<K, V> temp = entry;
            while (temp.next != null) {
                if (temp.key.equals(key)) return temp.value;
                temp = temp.next;
            }
            throw new NoSuchElementException();
        }

        return entry.value;
    }

    @Override
    public boolean containsKey(K key) {
        int index = bucketIndex(key);
        return entries[index] != null;
    }

    @Override
    public boolean containsValue(V value) {
        for (HashEntry<K, V> entry: entries) {
            if (entry == null) continue;
            if (entry.value.equals(value)) return true;
        }

        return false;
    }

    @Override
    public void remove(K key) {
        int index = bucketIndex(key);
        entries[index] = null;
        currentSize--;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void clear() {
        entries = new HashEntry[initialSize];
        currentSize = 0;
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        for (HashEntry<K, V> entry: entries) {
            if (entry == null) continue;
            set.add(entry.key);

            HashEntry<K, V> temp = entry.next;

            while (temp != null) {
                set.add(temp.key);
                temp = temp.next;
            }
        }
        return set;
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        int newLength = entries.length * 2;
        HashEntry<K, V>[] newEntries = new HashEntry[newLength];
        for (HashEntry<K, V> entry : entries) {
            if (entry == null) continue;
            int newIndex = bucketIndex(entry.key, newLength);
            newEntries[newIndex] = entry;
        }
        entries = newEntries;
    }

    private int bucketIndex(K key) {
        return bucketIndex(key, entries.length);
    }

    private int bucketIndex(K key, int size) {
        int hash = key.hashCode();
        return hash % size;
    }

    private static class HashEntry<K, V> {
        K key;
        V value;
        HashEntry<K, V> next;

        public HashEntry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
}
