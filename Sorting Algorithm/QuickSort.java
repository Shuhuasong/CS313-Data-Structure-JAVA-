public class QuickSort {

    public static int partition(int[] numbers, int i, int k)
    {

        int low = i;
        int high = k;
        //pick middle element as pivot
        int midPoint = i + (k-i)/2;
        int pivot = numbers[midPoint];
        boolean done = false;
        while(!done){
            while(numbers[low]<pivot){
                ++low;
            }
            while(numbers[high]>pivot){
                --high;
            }

            if(low>=high){
                done = true;
            }
            else{
                int temp = numbers[low];
                numbers[low]=numbers[high];
                numbers[high] = temp;

                ++low;
                --high;
            }
        }
        return high;
    }

    public static void quickSort(int[] numbers, int i, int k){
        //Base Case: If there are 1 or zero elements to sort
        //partition is already sorted
        if(i>=k){
            return;
        }
        //Partition the data within the array.
        int j = partition(numbers, i, k);
        quickSort(numbers, i, j);
        quickSort(numbers, j+1, k);
    }

    public static void main(String[] args){

        int numbers[] = {10, 2, 78, 4, 45, 32, 7, 11 };
        int size = numbers.length;
        System.out.println("Unsorted: ");
        for(int i=0; i<size; ++i){
            System.out.println(numbers[i] + " ");
        }
        quickSort(numbers, 0, size-1);
        System.out.println(("Sorted: "));
        for(int i=0; i<size; ++i){
            System.out.println(numbers[i] + " ");
        }
    }



}


