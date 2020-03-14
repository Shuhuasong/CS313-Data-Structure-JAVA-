import java.util.Scanner;

public class BinarySearchingRecursive {

   public static int binarySearch(int arr[], int start, int end, int key)
    {
        if(end>=1){
            int mid = (start+end)/2;
            if(arr[mid]==key)
                return mid;
            if(arr[mid]<key)
                return binarySearch(arr, mid+1, end, key);
            if(arr[mid]>key)
                return binarySearch(arr, start, mid-1, key);
        }
        return -1;
    }

    public static void main(String[] args)
    {
        BinarySearchingRecursive ob = new BinarySearchingRecursive();
        Scanner in = new Scanner(System.in);
        int numbers[] = { 2, 4, 7, 10, 11, 32, 45, 87 };
        int size = numbers.length;
        System.out.println("Numbers: ");
        for(int i = 0; i<size; i++)
        {
            System.out.println(numbers[i] + " ");
        }
        System.out.println("\nPlease enter a nubmer: ");
        int key = in.nextInt();
        int result = ob.binarySearch(numbers,0,size-1, key);
        if(result==-1){
            System.out.println(key + " is not found ");
        }
        else
        {
            System.out.println("Found "+key+" at index "+ result);
        }
    }
}
