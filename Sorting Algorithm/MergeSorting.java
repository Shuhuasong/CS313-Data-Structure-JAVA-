public class MergeSorting {

    public static void merge(int[] numbers, int i, int j, int k)
    {
        // Create temporary array mergedNumbers
        // Initialize position variables
        int mergeSize = k-i+1; // Size of merged partition
        int leftPos = 0; //Position of elements in left partition
        int rightPos = 0; //Position of elements in right partition
        int mergePos = 0; // Position to insert merged number
        int[] mergedNumbers = new int[mergeSize]; //Dynamically allocates temporary array for merged numbers

        leftPos = i;   // Initialize left partition position
        rightPos = j+1;  // Initialize right partition position
         // Add smallest element to merged numbers
        while(leftPos<=j && rightPos <= k)
        {
            if(numbers[leftPos] <= numbers[rightPos])
            {
                mergedNumbers[mergePos] = numbers[leftPos];
                ++leftPos; //??? why not leftPos++;
            }
            else
             {
                mergedNumbers[mergePos] = numbers[rightPos];
                ++rightPos;
             }
            ++mergePos;
        }
       // If left partition not empty, add remaining elements
        while(leftPos <= j)
        {
            mergedNumbers[mergePos] = numbers[leftPos];
            ++leftPos;
            ++mergePos;
        }
        // If right partition not empty, add remaining elements
        while(rightPos <=k)
        {
            mergedNumbers[mergePos] = numbers[rightPos];
            ++rightPos;
            ++mergePos;
        }
        //copy merge number back to numbers
        for( mergePos = 0; mergePos<mergeSize; ++mergePos)
        {
            numbers[i+mergePos] = mergedNumbers[mergePos];
        }
    }

    public static void MergeSort(int[] numbers, int i, int k)
    {
        int j=0;
        if(i<k)
        {
            j = (i+k)/2;  // Find the midpoint in the partition
            // Recursively sort left and right partitions
            MergeSort(numbers, i, j);
            MergeSort(numbers, j+1, k);
            // Merge left and right partition in sorted order
            merge(numbers, i, j, k);
        }
    }

    public static void main(String[] args)
    {
        int[] numbers =  { 10, 2, 78, 4, 45, 32, 7, 11 };
        int size = numbers.length;
        System.out.println("Unsorted: ");
        for(int i=0; i<size; i++)
        {
            System.out.println(numbers[i]+ " ");
        }

        MergeSort(numbers, 0, size-1);

        System.out.println("Sorted: ");
        for(int i=0; i<size; i++)
        {
            System.out.println(numbers[i] + " ");
        }
    }
}
