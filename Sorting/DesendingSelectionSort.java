import java.util.Scanner;
public class DesendingSelectionSort {
    // TODO: Write a void method selectionSortDescendTrace() that takes
    //       an integer array and the number of elements in the array as arguments,
    //       and sorts the array into descending order.
    public static void selectionSortDescendTrace(int [] numbers, int numElements)
    {
        int indexBigest = 0;
        for(int i=0; i<numElements-1; i++)
        {
            indexBigest = i;

            for(int j=i+1; i<numElements;j++)
            {
                if(numbers[j]>numbers[indexBigest])
                {
                    indexBigest = j;
                }
            }
            int temp = numbers[i];
            numbers[i] = numbers[indexBigest];
            numbers[indexBigest] = temp;

            for(int n=0; n<numElements; n++)
            {  System.out.print(numbers[n]+" "); }
        }
    }


    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        int input, i = 0;
        int numElements = 0;
        int [] numbers = new int[10];
        while(scnr.hasNext() && numbers.length<=10){
            numbers[i]=scnr.nextInt();
            i++;
        }
        // TODO: Read in a list of up to 10 positive integers; stop when
        //       -1 is read. Then call selectionSortDescendTrace() method.

        numElements = numbers.length;
        selectionSortDescendTrace(numbers, numElements);
        for(int k=0; k<numElements; k++)
        {  System.out.print(numbers[k]+" ");}
    }
}
