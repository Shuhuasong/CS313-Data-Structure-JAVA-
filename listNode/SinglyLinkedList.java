/* java.util.*;

public class SinglyLinkedList<E> implements List<E>, Queue<E> {
    private Node<E> first, last;
    private int size = 0;

    // Construct a new empty list.
    public SinglyLinkedList() {
        first = last = new Node<>(null);
    }

    // Adds the specified element to the end of the list.
    public void add(E e) {
        last.next = new Node<>(e);
        last = last.next;
        ++size;
    }

    // Inserts the specified element at the specified index.
    // The element previously at the index and all subsequent elements are shifted right (their index is increased by 1).
    // Throws an exception if the index is out of range.
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        Node<E> t = first;
        for (int i = 0; i < index; ++i) // Find the node before the point of insertion
            t = t.next;
        Node<E> newNode = new Node<>(e);
        newNode.next = t.next;
        t.next = newNode;
        if (index == size) // If the element was added at the end of the list, update last to point to the new node
            last = last.next;
        ++size;
    }

    // Adds the specified element to the end of the queue.
    public void enqueue(E e) {
        add(e);
    }

    // Removes and returns the first element of the list, or throws an exception if the list is empty.
    public E dequeue() {
        E e = first();
        first.next = first.next.next;
        --size;
        if (size == 0) // If the last element was removed, update last to point to the dummy node
            last = first;
        return e;
    }

    // Returns (but does not remove) the first element of the list, or throws an exception if the list is empty.
    public E first() {
        if (size == 0)
            throw new NoSuchElementException();
        return first.next.data;
    }

    // Returns the element at the specified index.
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        Node<E> t = first.next;
        for (int i = 0; i < index; ++i)
            t = t.next;
        return t.data;
    }

    public int size() {
        return size;
    }

    private static class Node<E> {
        E data;
        Node<E> next;
        Node(E data) {
            this.data = data;
        }
    }

    public Iterator<E> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<E> {
        private Node<E> current; // The node of the element that will be returned by next()
        Itr() {
            current = first.next;
        }

        // Returns true if there are more elements.
        public boolean hasNext() {
            return current != null;
        }

        // Returns the next element.
        public E next() {
            if (!hasNext())
                throw new NoSuchElementException();
            E e = current.data;
            current = current.next;
            return e;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}

 */