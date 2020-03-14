package BinarySearchTree;

import java.util.Map;

/*public class BSTreeMap<K extends Comparable<K>, V> implements Map<K, V> { // K must be a class that implements Comparable
    private Entry<K, V> root;

    // Construct a new empty map.
    public BSTreeMap() {
    }

    // Adds the specified key-value pair.
    // If the key is already in the map, the old value is replaced.
    public void put(K k, V v) {
        root = put(k, v, root);
    }

    // Adds the specified key-value pair and returns the root.
    private Entry<K, V> put(K k, V v, Entry<K, V> root) {
        if (root == null) return new Entry<>(k, v); // Key not found, so add the pair.
        int compare = k.compareTo(root.key);
        if (compare < 0)                    // If k < root.key, add it to the left subtree.
            root.left = put(k, v, root.left);
        else if (compare > 0)               // If k > root.key, add it to the right subtree.
            root.right = put(k, v, root.right);
        else
            root.value = v;                  // If the key is already in the map, replace the old value.
        return root;
    }

    // Removes the pair with the specified key.
    public void remove(K k) {
        root = remove(k, root);
    }

    // Removes the pair with the specified key and returns the root.
    private Entry<K, V> remove(K k, Entry<K, V> root) {
        if (root == null) return null;         // Key not found.
        int compare = k.compareTo(root.key);
        if (compare < 0)                       // If k < root.key, remove it from the left subtree.
            root.left = remove(k, root.left);
        else if (compare > 0)                  // If k > root.key, remove it from the left subtree.
            root.right = remove(k, root.right);
        else {                                            // If k == root.key,
            if (root.left == null) return root.right;      // Case with 0 or 1 subtree (right).
            else if (root.right == null) return root.left; // Case with 1 subtree (left).
            Entry<K, V> t = root.right;
            while (t.left != null) t = t.left;      // Case with 2 subtrees:
            root.key = t.key;                       // Replace root's pair with min-key pair in right subtree.
            root.value = t.value;
            root.right = remove(t.key, root.right); // Remove the min-key pair from right subtree.
        }
        return root;
    }

    // Returns true if the map contains the specified key.
    public boolean containsKey(K k) {
        return containsKey(k, root);
    }

    // Returns true if the map contains the specified key.
    private boolean containsKey(K k, Entry<K, V> root) {
        if (root == null) return false;    // Key not found.
        int compare = k.compareTo(root.key);
        if (compare < 0)                   // If k < root.key, search the left subtree.
            return containsKey(k, root.left);
        else if (compare > 0)              // If k > root.key, search the right subtree.
            return containsKey(k, root.right);
        return true;                       // If k == root.key, return true.
    }

    // Returns the value of the specified key, or null if the key is not in the map.
    public V get(K k) {
        return get(k, root);
    }

    private V get(K k, Entry<K, V> root) {
        if (root == null) return null;     // Key not found, so return null.
        int compare = k.compareTo(root.key);
        if (compare < 0)                   // If k < root.key, search the left subtree.
            return get(k, root.left);
        else if (compare > 0)              // If k > root.key, search the right subtree.
            return get(k, root.right);
        return root.value;                 // Key found, so return the value.
    }

    private static class Entry<K extends Comparable<K>, V> {
        K key;
        V value;
        Entry<K, V> left = null, right = null;

        Entry(K k, V v) {
            key = k;
            value = v;
        }
    }


}

 */

