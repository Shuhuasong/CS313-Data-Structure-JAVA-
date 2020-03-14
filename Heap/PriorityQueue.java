package Heap;

import java.util.*;

// Implemented with a min heap.
public class PriorityQueue<E extends Comparable<E>> implements Iterable<E> {
    private E[] heap; // heap[1] is the root
    private int size;

    // Constructs a new priority queue with the specified capacity.
    @SuppressWarnings("unchecked")
    public PriorityQueue(int capacity) {
        heap = (E[])new Comparable[capacity+1];
        size = 0;
    }

    // Constructs a new priority queue with the default capacity (10).
    public PriorityQueue() {
        this(10);
    }

    // Adds the element to the priority queue.
    public void insert(E e) {
        if (size+1 == heap.length) // If out of space, copy the elements into a larger array
            heap = Arrays.copyOf(heap, heap.length * 2);
        heap[++size] = e; // Place the new element one spot after the last element
        // Bubble-up the new element
        bubbleUp(size);
    }

    // Bubbles up the element at index i.
    // While the element is smaller than its parent, swap it with its parent.
    private void bubbleUp(int i) {
        while (i > 1) { // If the element is already at the root, end the loop
            if (heap[i].compareTo(heap[i/2]) >= 0) break;
            swap(i, i/2);
            i /= 2;
        }
    }

    // Swaps the elements at indices i and j
    private void swap(int i, int j) {
        E temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Returns (but does not remove) the smallest element, or throws an exception if the queue is empty.
    public E min() {
        if (size == 0)
            throw new NoSuchElementException();
        return heap[1];
    }

    // Removes and returns the smallest element, or throws an exception if the queue is empty.
    public E removeMin() {
        E e = min();
        heap[1] = heap[size]; // Move the last element to the top of the heap
        heap[size--] = null;
        // Bubble-down the element that you moved to the top of the heap
        bubbleDown(1);
        return e; // Return the smallest element
    }

    // Bubbles down the element at index i.
    // While the element is larger than one or both children, swap it with its smaller child
    // (note that there may be only one child)
    private void bubbleDown(int i) {
        while (i*2 <= size) { // If the element does not have any children, end the loop
            int smallerChild = i*2; // Initialize smallerChild to the left child
            if (i*2+1 <= size && heap[i*2+1].compareTo(heap[i*2]) < 0) // Check if there's a smaller right child
                ++smallerChild;
            if (heap[i].compareTo(heap[smallerChild]) <= 0) break;
            swap(i, smallerChild);
            i = smallerChild;
        }
    }

    public int size() {
        return size;
    }

    // Prints the heap.  The indices are shown in parentheses.
    public void print() {
        for (int i = 1; i <= size; ++i)
            System.out.print(heap[i] + "(" + i + ") ");
    }

    public Iterator<E> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<E> {
        private int current; // The index of the element that will be returned by next()
        Itr() {
            current = 1;
        }

        public boolean hasNext() {
            return current <= size;
        }

        public E next() {
            if (current > size)
                throw new NoSuchElementException();
            return heap[current++];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}



