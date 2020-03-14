package BinarySearchTree.MethodForBST;

public abstract class AbstractBSTSet<E extends Comparable<E>> implements Set<E> {
    public Node<E> root;

    // Adds the specified element (if it is not already in the set).
    public void add(E e) {
        root = add(e, root);
    }

    // Adds the specified element (if it is not already in the set) and returns the root.
    private Node<E> add(E e, Node<E> root) {
        if (root == null) return new Node<>(e); // Element not found, so add it.
        int compare = e.compareTo(root.data);
        if (compare < 0)                    // If e < root.data, add it to the left subtree.
            root.left = add(e, root.left);
        else if (compare > 0)               // If e > root.data, add it to the right subtree.
            root.right = add(e, root.right);
        return root;                        // If e == root.data, don't add it.
    }

    // Removes the specified element.
    public void remove(E e) {
        root = remove(e, root);
    }

    // Removes the specified element and returns the root.
    private Node<E> remove(E e, Node<E> root) {
        if (root == null) return null;         // Element not found.
        int compare = e.compareTo(root.data);
        if (compare < 0)                       // If e < root.data, remove it from the left subtree.
            root.left = remove(e, root.left);
        else if (compare > 0)                  // If e > root.data, remove it from the right subtree.
            root.right = remove(e, root.right);
        else {                                            // If e == root.data,
            if (root.left == null) return root.right;      // Case with 0 or 1 subtree (right).
            else if (root.right == null) return root.left; // Case with 1 subtree (left).
            Node<E> t = root.right;                  // Case with 2 subtrees:
            while (t.left != null) t = t.left;       // Find the successor (min element in right subtree).
            root.data = t.data;                      // Replace root.data with the successor.
            root.right = remove(t.data, root.right); // Remove the min value from right subtree.
        }
        return root;
    }
}