package BinarySearchTree.MethodForBST;

public interface Set<E> {
    // Adds the given element to the set if it's not already added.
    void add(E e);

    // Removes the given element from the set.
    void remove(E e);

    // Returns true if the given element is in the set.
    boolean contains(E e);
}