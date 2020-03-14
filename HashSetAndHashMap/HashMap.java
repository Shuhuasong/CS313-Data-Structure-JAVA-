package HashSetAndHashMap;
//Hashing Out Hash Functions:


// Separate chaining
public class HashMap<K, V> implements Map<K, V> {
    private Entry<K, V> table[];

    // Constructs a new empty hash table with the default number of buckets (11).
    @SuppressWarnings("unchecked")
    public HashMap() {
        table = (Entry<K, V>[]) new Entry[11];
    }

    // Adds the specified key-value pair to the map.
    // If the key is already in the map, the old value is replaced.
    public void put(K k, V v) {
        int hash = hash(k); // Compute the array index
        for (Entry<K, V> i = table[hash]; i != null; i = i.next) {
            if (k.equals(i.key)) { // If the key is already in the map, replace the old value
                i.value = v;
                return;
            }
        }
        table[hash] = new Entry<>(k, v, table[hash]); // Add the pair to the front of the list?????
    }

    // Removes the pair with the specified key.
    public void remove(K k) {
        int hash = hash(k); // Compute the array index
        // If the pair is in the table, remove it
        for (Entry<K, V> i = table[hash], prev = i; i != null; prev = i, i = i.next) { //why we need to sign the Prev = i second time????
            if (k.equals(i.key)) {
                if (table[hash] == i)              // Case where it's the first pair of the list
                    table[hash] = table[hash].next;
                else                               // Case where it's not the first pair
                    prev.next = i.next;
                return;
            }
        }
    }

    // Returns true if the map contains the specified element.
    public boolean containsKey(K k) {
        int hash = hash(k);                                     // Compute the array index
        for (Entry<K, V> i = table[hash]; i != null; i = i.next) // If the element is in the table, return true
            if (k.equals(i.key))
                return true;
        return false;
    }

    // Returns the value of the specified key, or null if the key is not in the map.
    public V get(K k) {
        int hash = hash(k);                                      // Compute the array index
        for (Entry<K, V> i = table[hash]; i != null; i = i.next) // If the key is found, return the value
            if (k.equals(i.key))
                return i.value;
        return null;                                             // Key not found, so return null
    }

    // Computes the array index in the range [0, table.length-1]
    private int hash(K k) {
        return (k.hashCode() & 0x7FFFFFFF) % table.length; // Avoid negative indices
    }

    // Prints the hash table (1 bucket per line).  Entries are printed as key=value.
    public void print() {
        for (int bucket = 0; bucket < table.length; ++bucket) {
            System.out.print("Bucket " + bucket + ":");
            for (Entry<K, V> i = table[bucket]; i != null; i = i.next)
                System.out.print(" " + i.key + "=" + i.value);
            System.out.println();
        }
    }

    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;
        Entry(K k, V v, Entry<K, V> n) {
            key = k;
            value = v;
            next = n;
        }
    }
}