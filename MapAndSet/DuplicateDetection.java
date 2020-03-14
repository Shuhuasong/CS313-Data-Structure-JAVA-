package Set;

import java.util.HashSet;
import java.util.Set;

public class DuplicateDetection {
    // Returns true if the array contains a duplicate, otherwise returns false.
    public static boolean containsDuplicates(int[] a) {
        Set<Integer> set = new HashSet<>();
        for (int i : a) { // For each element, check if it's already in the set, then add it to the set
            if (set.contains(i))
                return true;
            set.add(i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {3, 1, 4, 1, 5, 9, 2, 6};
        System.out.println(containsDuplicates(a));
    }
}
