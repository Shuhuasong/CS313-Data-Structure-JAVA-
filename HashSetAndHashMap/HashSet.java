package HashSetAndHashMap;

// Separate chaining
/*  public class HashSet<E> implements Set<E> {
    private Node<E> table[];

    // Construct a new empty hash table with the default number of buckets (11).
    @SuppressWarnings("unchecked")
    public HashSet() {
        table = (Node<E>[]) new Node[11];
    }

    // Adds the specified element (if it is not already in the set).
    public void add(E e) {
        int hash = hash(e); // Compute the array index
        for (Node<E> i = table[hash]; i != null; i = i.next)
            if (e.equals(i.data)) // If the element is already in the table, don't add it
                return;
        table[hash] = new Node<>(e, table[hash]); // Add the element to the front of the list  //how we know it is add in the front
    }

    // Removes the specified element (if it is in the hash table).
    public void remove(E e) {
        int hash = hash(e); // Compute the array index
        // If the element is in the table, remove it
        for (Node<E> i = table[hash], prev = i; i != null; prev = i, i = i.next) {
            if (e.equals(i.data)) {
                if (table[hash] == i)              // Case where it's the first element of the list
                    table[hash] = table[hash].next;
                else                               // Case where it's not the first element
                    prev.next = i.next; //why is not: prev = prev.next;
                return;
            }
        }
    }
w
    // Returns true if the hash table contains the specified element.
    public boolean contains(E e) {
        int hash = hash(e);                                  // Compute the array index
        for (Node<E> i = table[hash]; i != null; i = i.next) // If the element is in the table, return true
            if (e.equals(i.data))
                return true;
        return false;
    }

    // Computes the array index in the range [0, table.length-1].
    private int hash(E e) {
        return (e.hashCode() & 0x7FFFFFFF) % table.length; // Avoid negative indices
    }

    // Prints the hash table (1 bucket per line).
    public void print() {
        for (int bucket = 0; bucket < table.length; ++bucket) {
            System.out.print("Bucket " + bucket + ":");
            for (Node<E> i = table[bucket]; i != null; i = i.next)
                System.out.print(" " + i.data);
            System.out.println();
        }
    }

    private static class Node<E> {
        E data;
        Node<E> next;
        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }


}
*/
