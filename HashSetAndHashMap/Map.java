package HashSetAndHashMap;

public interface Map<K, V> {
    // Adds the specified key-value pair.
    void put(K k, V v);

    // Removes the pair with the specified key.
    void remove(K k);

    // Returns true if the specified key is in the map.
    boolean containsKey(K k);

    // Returns the value of the given key, or null if the key is not in the map.
    V get(K k);
}