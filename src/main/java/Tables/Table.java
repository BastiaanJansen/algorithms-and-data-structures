package Tables;

import java.util.Map;
import java.util.Set;

public interface Table<K, V> {
    void put(K key, V value);
    void putAll(Map<? extends K, ? extends V> map);
    void putAll(Table<K, ? extends V> table);
    V get(K key);
    boolean containsKey(K key);
    boolean containsValue(V value);
    void remove(K key);
    void clear();
    Set<K> keySet();
    int size();
    boolean isEmpty();
}
