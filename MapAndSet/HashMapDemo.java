//https://www.geeksforgeeks.org/map-interface-java-examples/
package MapAndSet;
import java.util.*;
import java.util.Set;

class HashMapDemo{
    public static void main(String args[])
    {
        Map<String, Integer> hm = new HashMap<String, Integer>();
        hm.put("a", new Integer(100));
        hm.put("b", new Integer(2100));
        hm.put("c", new Integer(300));
        hm.put("d", new Integer(400));

        Set<Map.Entry<String, Integer>> St = hm.entrySet();
        for(Map.Entry<String, Integer>  me:St)
        {
            System.out.print(me.getKey()+":");
            System.out.println(me.getValue());
        }
    }
}