package ArrayList;

import java.util.*;

// A non-generic ArrayList class
public class ArrayListInt implements ListInt {
    private int[] elements;
    private int size;

    // Constructs a new empty list with the specified capacity.
    public ArrayListInt(int capacity) {
        elements = new int[capacity];
        size = 0;
    }

    // Constructs a new empty list with the default capacity (10).
    public ArrayListInt() {
        this(10);
    }

    // Adds the element to the end of the list.
    public void add(int e) {
        if (size == elements.length)
            elements = Arrays.copyOf(elements, elements.length * 2);
        elements[size++] = e;
    }

    // Returns the element at the specified index.
    public int get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        return elements[index];
    }

    public int size() {
        return size;
    }
}