import java.util.Scanner;
import java.util.ArrayList;

public class MergeSortLab {
    public static void merge(int [] nums1, int m, int [] nums2, int n){
        //int mergeSize = m+n;
        int leftPos = 0 ;
        int rightPos = 0;
        int mergePos = 0;
        int[] temp = new int[m];
        //copy all the number in the nums1 array into a temp array
        for(int i=0; i<m; i++)
        {
            temp[i] = nums1[i];
        }

        while(leftPos<m && rightPos<n)
        {
            if(temp[leftPos] <nums2[rightPos])
            {
                nums1[mergePos] = temp[leftPos];
                ++leftPos;
            }
            else
            {
                nums1[mergePos] = nums2[rightPos];
                ++rightPos;
            }
            ++mergePos;
        }
        // when the array temp is not empty
        while(leftPos<m)
        {
            nums1[mergePos] = temp[leftPos];
            ++leftPos;
            ++mergePos;
        }
        //when the arrauy num2 is not empty
        while(rightPos<n)
        {
            nums1[mergePos] = nums2[rightPos];
            ++rightPos;
            ++mergePos;
        }

    }


    public static void main(String [] args)
    {
        //Variables
        Scanner scnr = new Scanner(System.in);
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        int [] arr1, arr2;
        int split = 0;

        //Remaining values will be added to the array
        //while(scnr.hasNext())
        while(!scnr.next().equals("-1"))
        {
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
        merge(arr1,split+1,arr2,arrList.size()-(split+1));
        //Prints elements in arr1 after merge
        for(int i : arr1)
            System.out.println(i);
    }
}