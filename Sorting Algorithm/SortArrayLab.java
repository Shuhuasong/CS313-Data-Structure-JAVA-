

import java.util.ArrayList;
import java.util.Scanner;

public class SortArrayLab<size> {
    Scanner  scan = new Scanner(System.in);
    ArrayList<Integer> arrList = new ArrayList<Integer>;
    int[] numbers;
    int size = scan.nextInt();;
       while(scan.hasNext()){
           arrList.add(scan.nextInt());
    }
       for(int i=0; i<arrList.size(); i++)
       {
           numbers[i] = arrList.get(i);
       }

       quickSort(numbers, 0, size-1);

       for(int i : numbers)
    {
        System.out.println(numbers[i] + " ");
    }

      public static int partition(int[] numbers, int i, int k)
      {
          int low = i;
          int high = k;
          int midPoint = i+(k-i)/2;
          int pivot = numbers[midPoint];
          boolean done = false;
          while(!done)
          {
              while(numbers[low]<=pivot){
                  ++low;
              }
              while(numbers[high]>=pivot){
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

}



    public static void main(String [] args) {
        //Variables
        Scanner scnr = new Scanner(System.in);
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        int [] arr1, arr2;
        int split = 0;
        Solution test = new Solution();
        //Remaining values will be added to the array
        while(scnr.hasNext()){
            arrList.add(scnr.nextInt());
            //Get position to mark end of arr1 and beginning of arr2
            if(arrList.size() >= 2 && arrList.get(arrList.size()-1) <= arrList.get(arrList.size()-2))
                split = arrList.size()-1;
        }
        //Instance primitive array to size of ArrayList
        arr1 = new int[arrList.size()];
        arr2 = new int[arrList.size()-(split+1)];
        //Copy elements from ArrayList to primitive array
        for(int i = 0; i < (split+1); i++)
            arr1[i] = arrList.get(i);
        for(int i = 0; i < arrList.size()-(split+1); i++)
            arr2[i] = arrList.get(split+i);
        //Test values
        test.merge(arr1,split+1,arr2,arrList.size()-(split+1));
        //Prints elements in arr1 after merge
        for(int i : arr1)
            System.out.println(i);
    }