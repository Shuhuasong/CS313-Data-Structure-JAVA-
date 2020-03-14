//https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html


import java.util.*;

public class ArrayList<E> implements List<E> {
    private E[] elements;
    private int size;

    // Constructs a new empty list with the specified capacity.
    @SuppressWarnings("unchecked")
    public ArrayList(int capacity) {
        elements = (E[])new Object[capacity];
        size = 0;
    }

    // Constructs a new empty list with the default capacity (10).
    public ArrayList() {
        this(10);
    }

    // Adds the element to the end of the list.
    public void add(E e) {
        if (size == elements.length) // If out of space, copy the elements into a larger array
            elements = Arrays.copyOf(elements, elements.length * 2);
        elements[size++] = e;
    }

    // Returns the element at the specified index.
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        return elements[index];
    }

    public int size() {
        return size;
    }
}