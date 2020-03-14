/* package StackAndQueue;

import java.util.*;

public class ArrayQueue<E> implements Queue<E> {
    private E[] elements;
    private int front; // The index of the front element
    private int back; // The index one past the last element
    private int size;

    // Constructs a new empty queue.
    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        elements = (E[])new Object[capacity];
        front = back = size = 0;
    }

    // Adds the element to the end of the queue.
    public void enqueue(E e) {
        if (size == elements.length) { // If out of space, copy the elements into a larger array
            @SuppressWarnings("unchecked")
            E[] a = (E[])new Object[elements.length * 2];                     // Copy the elements in two steps (because of wrapping):
            //System.arraycopy(source_arr, sourcePos, dest_arr, destPos, len);
            System.arraycopy(elements, front, a, 0, elements.length - front); // Copy the elements after front //??????
            System.arraycopy(elements, 0, a, elements.length - front, front); // Copy the elements before front //??????
            front = 0;
            back = elements.length;
            elements = a;
        }
        elements[back] = e;
        back = (back + 1) % elements.length;
        ++size;
    }

    // Removes and returns the first element of the queue, or throws an exception if the queue is empty.
    public E dequeue() {
        E e = first();
        elements[front] = null; // Set the reference to null so the garbage collector can delete the object
        front = (front + 1) % elements.length;
        --size;
        return e;
    }

    // Returns (but does not remove) the first element of the queue, or throws an exception if the queue is empty.
    public E first() {
        if (size == 0)
            throw new NoSuchElementException();
        return elements[front];
    }

    public boolean empty(){
        return size==0;
    }

    public int size() {
        return size;
    }
}

 */