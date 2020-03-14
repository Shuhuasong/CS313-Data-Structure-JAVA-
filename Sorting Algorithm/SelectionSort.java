public class SelectionSort {

    public static void selectionSort(int[] numbers)
    {
      int  indexSmallest = 0;
      int size = numbers.length;
      for(int i=0; i<size-1; i++){
          indexSmallest = i;  //Find index of smallest remaining element
          for(int j=i+1; j<size; j++){
              if(numbers[j]<numbers[indexSmallest]){
                  indexSmallest = j;
              }
          }
          //Swap number[i] and number[indexSmallest]
          int temp = numbers[i];
          numbers[i] = numbers[indexSmallest];
          numbers[indexSmallest]= temp;

      }
    }

    public static void main(String[] args)
    {
        int numbers[] = { 10, 2, 78, 4, 45, 32, 7, 11 };
        int numSize = numbers.length;
        System.out.println("Unorderd: ");
        for(int i=0; i<numSize-1; i++)
        {
            System.out.println(numbers[i] + " ");
        }
        System.out.println();

        selectionSort(numbers);
        System.out.println("Sorted: ");
        for(int i=0; i<numSize; i++)
        {
            System.out.println(numbers[i] + " ");
        }
        System.out.println();
    }
}
