public class InserSorting {

    public static void insertSort(int[] numbers)
    {   int comparison = 0;
        int size = numbers.length;
        for(int i=0; i<size; i++)
        {
            int j= i;
            while(j>0 && numbers[j] < numbers[j-1])
            {   comparison++;
                int temp = numbers[j];
                numbers[j] = numbers[j-1];
                numbers[j-1] = temp;
                --j;
            }
        }
        System.out.println("Comparison: " + comparison);
    }

    public static void main(String[] args)
    {
        int numbers[] = { 10, 2, 78, 4, 45, 32, 7, 11,56,30 };
        int numSize = numbers.length;
        System.out.println("Unorderd: ");
        for(int i=0; i<numSize-1; i++)
        {
            System.out.println(numbers[i] + " ");
        }
        System.out.println();

        insertSort(numbers);
        System.out.println("Sorted: ");
        for(int i=0; i<numSize; i++)
        {
            System.out.println(numbers[i] + " ");
        }
        System.out.println();
    }
}
