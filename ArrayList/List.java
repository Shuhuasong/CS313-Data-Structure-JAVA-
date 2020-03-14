package ArrayList;

public interface List<E> {
    // Adds the specified element to the end of the list.
    void add(E e);

    // Returns the element at the specified index.
    E get(int index);

    int size();
}