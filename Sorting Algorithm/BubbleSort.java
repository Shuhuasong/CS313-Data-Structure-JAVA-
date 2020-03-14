public class BubbleSort {
    public static void bubbleSort(int[] arr)
    {
        int size = arr.length;
        for(int i=0; i<size-1; i++)
        {
            for(int j=0; j<size-i-1; j++)
            {
                if(arr[j]>arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void printArray(int arr[])
    {
        int size = arr.length;
        for(int i=0; i<size; i++)
        {
            System.out.println(arr[i] + " ");
            System.out.println( );
        }
    }

    public static void main(String[] args)
    {
        int numbers[] = { 10,30,70,40,80,20,50};
        bubbleSort(numbers);
        System.out.println("Sorted array: ");
        printArray(numbers);
    }
}
