
public class LinearSearching {

    public static void main(String[] args)
    {
        int numbers[] = { 2, 3, 4, 10, 40 };
        int target = 10;
        int result = linearSearch(numbers, target);
            if(result==-1)
                System.out.println("the number is not in the array");
            else
                System.out.println("the number is int the position of " + result);
    }


    public static int linearSearch(int arr[],  int key)
    {
        int arraySize = arr.length;
        for(int i=0; i<arraySize; i++)
        {
            if(key==arr[i]){
                return i;
            }
        }
        return -1;
    }
}

