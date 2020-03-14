
/*import java.util.ArrayList;
import java.util.*;

public class ArrayListEx1 {

    public static void main(String[] args) {
        int[] array = new int[10]; // Creates a 0-initialized array of size 10
        array[0] = 5; // Sets the element at index 0 to 5
        Arrays.sort(array); // Sort the array
        System.out.println("Array: ");
        System.out.println(Arrays.toString(array)); // Prints the array

        List<Integer> list1 = new ArrayList<>(); // Creates an empty ArrayList with the default initial capacity (10)
        list1.add(5); // Adds 5 to the end of the list
        list1.add(6);
        list1.add(4);
        list1.set(0, 7); // Sets the element at index 0 to 7
        list1.remove(0); // Removes the element at index 0
        System.out.println("list1: ");
        System.out.println(list1); // Prints the ArrayList
        for (int i = 0; i < list1.size(); ++i) // Prints the ArrayList with a loop
            System.out.print(list1.get(i) + " ");
        System.out.println();

        List<Integer> list2 = new LinkedList<>(list1); // Creates a LinkedList containing the same elements as list1
        System.out.println("list2: ");
        for (int i : list2) // Prints the LinkedList with a for-each loop
            System.out.print(i + " ");

        List<Integer> list3 = new LinkedList<>(); // Creates an empty LinkedList
        list3.add(5); // Adds 5 to the end of the list
        Collections.sort(list3); // Sorts the LinkedList
    }
}  */