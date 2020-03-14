/*package MapAndSet;

// Java code for demonstrating union, intersection and difference
// on Set
import java.util.*;
public class Set_hashSet
{
    public static void main(String args[])
    {
        Set<Integer> a = new HashSet<Integer>();
        a.addAll(Arrays.asList(new Integer[] {1, 3, 2, 4, 8, 9, 0}));//The asList() method of java.util.Arrays class is used to return a fixed-size
                                                                      // list backed by the specified array.
        Set<Integer> b = new HashSet<Integer>();
        b.addAll(Arrays.asList(new Integer[] {1, 3, 7, 5, 4, 0, 7, 5}));

        // To find union
        Set<Integer> union = new HashSet<Integer>(a);
        union.addAll(b);
        System.out.print("Union of the two Set");
        System.out.println(union);

        // To find intersection
        Set<Integer> intersection = new HashSet<Integer>(a);
        intersection.retainAll(b);
        System.out.print("Intersection of the two Set");
        System.out.println(intersection);

        // To find the symmetric difference
        Set<Integer> difference = new HashSet<Integer>(a);
        difference.removeAll(b);
        System.out.print("Difference of the two Set");
        System.out.println(difference);
        //Initializing HashSet
        //Using Constructor
        Integer arr[] = { 5, 6, 7, 8, 1, 2, 3, 4, 3 };
        Set<Integer> set = new HashSet<>(Arrays.asList(arr));
        //Using Collection

    }


}

 */