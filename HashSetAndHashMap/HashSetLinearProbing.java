 package HashSetAndHashMap;

/*public class HashSetLinearProbing<E> implements Set<E> {
    private E table[];
    @SuppressWarnings("unchecked")
    private E deleted = (E) new Object();

    // Construct a new empty hash table with the default number of buckets (11).
    @SuppressWarnings("unchecked")
    public HashSetLinearProbing() {
        table = (E[]) new Object[11];
    }

    // Adds the specified element (if it is not already in the set, and there is room for it).
    public void add(E e) {
        if (contains(e)) // If the element is already in the table, don't add it
            return;
        int hash = hash(e), probe = hash; // Compute the array index //?????
        do { // Add the element to the first empty or deleted slot
            if (table[probe] == null || table[probe] == deleted) {
                table[probe] = e;
                return;
            }
            probe = (probe+1) % table.length;
        } while (probe != hash);
    }

    // Removes the specified element from the hash table (if it is in the hash table).
    public void remove(E e) {
        int hash = hash(e), probe = hash; // Compute the array index
        do { // If the element is in the table, mark it as deleted
            if (table[probe] == null) // Stop searching when you reach null
                return;
            if (e.equals(table[probe])) {
                table[probe] = deleted;
                return;
            }
            probe = (probe+1) % table.length;
        } while (probe != hash);
    }

    // Returns true if the hash table contains the specified element.
    public boolean contains(E e) {
        int hash = hash(e), probe = hash; // Compute the array index
        do { // If the element is in the table, return true
            if (table[probe] == null) // Stop searching when you reach null
                return false;
            if (e.equals(table[probe]))
                return true;
            probe = (probe+1) % table.length;
        } while (probe != hash);
        return false;
    }

    // Computes the array index in the range [0, table.length-1].
    private int hash(E e) {
        return (e.hashCode() & 0x7FFFFFFF) % table.length; // Avoid negative indices
    }

    // Prints the hash table (1 bucket per line).
    public void print() {
        for (int i = 0; i < table.length; ++i)
            System.out.println("Bucket " + i + ": " + (table[i] == deleted ? "deleted" : table[i]));
    }
}
*/
