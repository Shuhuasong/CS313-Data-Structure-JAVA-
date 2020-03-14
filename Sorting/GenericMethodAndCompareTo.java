import java.util.Scanner;

public class GenericMethodAndCompareTo {
    public static <T extends Comparable<T>> int checkOrder(T t1, T t2, T t3, T t4){
        int val1 = t1.compareTo(t2);
        int val2 = t2.compareTo(t3);
        int val3 = t3.compareTo(t4);
        if(val1 > 0 && val2 >0 && val3 >0){
            return 1;
        }
        else if(val1<0 && val2<0 && val3<0){
            return -1;
        }
        else{
            return 0;
        }
    }

    // Check the order of the input: return -1 for ascending,
    // 0 for neither, 1 for descending



    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        // Check order of four strings
        System.out.println("Order: " + checkOrder(scnr.next(), scnr.next(), scnr.next(), scnr.next()));

        // Check order of four doubles
        System.out.println("Order: " + checkOrder(scnr.nextDouble(), scnr.nextDouble(), scnr.nextDouble(), scnr.nextDouble()));
    }
}
