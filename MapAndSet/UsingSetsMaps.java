/*package Set;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class UsingSetsMaps {
    // Both Set and Map have a Tree version and a Hash version.
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>(); // Creates an empty TreeSet
        set.add(3); // Adds 3
        System.out.println(set.contains(3)); // Prints true if the set contains 3, otherwise false
        System.out.println(set); // Prints the TreeSet (the elements are sorted because it's a TreeSet)
        for (int i : set) // Prints the TreeSet with a for-each loop
            System.out.print(i + " ");
        set.remove(3); // Removes 3
        System.out.println();

        Map<Integer, Integer> map = new HashMap<>(); // Creates an empty HashMap
        map.put(3, 5); // Adds key 3 with value 5
        map.put(3, 7); // Updates the value of key 3 to 7
        System.out.println(map.containsKey(3)); // Prints true if the map contains key 3, otherwise false
        System.out.println(map.get(3)); // Prints the value associated with key 3
        System.out.println(map); // Prints the HashMap (the keys are not sorted because it's a HashMap)
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) // Prints the HashMap with a for-each loop
            System.out.print(entry.getKey() + "=" + entry.getValue() + " ");
        map.remove(3); // Removes key 3 from the map
    }
}*/
