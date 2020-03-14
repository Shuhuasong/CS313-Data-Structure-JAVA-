package BinarySearchTree.MethodForBST;

public class Node<E extends Comparable<E>> {
    E data;
    Node<E> left = null, right = null;

    Node(E data) {
        this.data = data;
    }
}