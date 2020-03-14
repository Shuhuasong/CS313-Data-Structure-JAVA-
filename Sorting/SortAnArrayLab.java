import java.util.Scanner;
import java.util.ArrayList;

public class SortAnArrayLab {
    public static int partition(int[] numbers, int i, int k)
    {
        int low = 0;
        int high = 0;
        low = i;
        high = k;
        int midPoint = i+(k-i)/2;
        int pivot = numbers[midPoint];
        boolean done = false;
        while(!done)
        {
            while(numbers[low]<pivot){
                ++low;
            }
            while(numbers[high]>pivot){
                --high;
            }
            if(low>=high){
                done = true;
            }
            else
            {
                int temp = numbers[low];
                numbers[low] = numbers[high];
                numbers[high] = temp;
                ++low;
                --high;
            }
        }
        return high;
    }

    public static void quickSort(int[] numbers, int i, int k)
    {
        int j = 0;
        if(i>=k){
            return;
        }
        j = partition(numbers, i, k);
        quickSort(numbers, i, j);
        quickSort(numbers, j+1, k);
    }

    public static void main(String[] args) {
        Scanner  scan = new Scanner(System.in);
        ArrayList<Integer> arrList = new ArrayList<Integer>();

        int size = scan.nextInt();;
        while(scan.hasNext()){
            arrList.add(scan.nextInt());
        }
        int arraySize = arrList.size();
        int[] numbers = new int[arraySize];
        for(int i=0; i<arrList.size(); i++)
        {
            numbers[i] = arrList.get(i);
        }

        //System.out.println("Unsorted: ");
        //System.out.print(size + " ");
        //for(int i=0; i<arraySize; i++)
        // {
        // System.out.print(numbers[i] + " ");
        //}
        //System.out.println();
        quickSort(numbers, 0, size-1);
        //System.out.println("Sorted: ");
        for(int i=0; i<arraySize; i++)
        {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }
}
