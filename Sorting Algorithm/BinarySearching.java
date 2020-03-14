import java.util.Scanner;

public class BinarySearching {

    public static int binarySearch(int arr[], int key)
    {
        int arraySize = arr.length;
        int mid = 0;
        int low = 0;
        int high = arraySize - 1;

        while(low<=high)
        {
            mid = (low+high)/2;
            if(arr[mid]<key)
            {
                low = mid + 1;
            }
            else if(arr[mid]>key)
            {
                high = mid - 1;
            }
            else
            {
                return mid;
            }
        }
        return -1; //not found
    }

    public static void main(String[] args)
    {
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
        int result = binarySearch(numbers, key);
        if(result==-1){
            System.out.println(key + " is not found ");
        }
        else
        {
            System.out.println("Found "+key+" at index "+ result);
        }
    }
}
