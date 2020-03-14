//https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
/*import java.util.Scanner;
import java.util.StringTokenizer;

public class PermutationOfname {

    // TODO: Write method to create and output all permutations of the list of names.
    public static void allPermutations(ArrayList<String> permList, ArrayList<String> nameList) {
        int i = 0;
        int j = nameList.size();
        permute(permList,  nameList,i, j);
    }

    public static void permute(ArrayList<String> permList, ArrayList<String> nameList,int l, int r)
    {

        if(l == r)
            System.out.println(nameList);
        else
        {
            for(int i = 0; i<r; i++)
            {
              permList = swap(permList, l, i);
              permute(permList,  nameList,l+1, r);
                permList = swap(permList, l, i);
            }
        }
    }

    public static ArrayList<String> swap(ArrayList<String> nameList, int i, int j){
        String temp = nameList.get(i);
        nameList.set(i, nameList.get(j));
        nameList.set(j,temp);
        return  nameList;
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        ArrayList<String> nameList = new ArrayList<String>();
        ArrayList<String> permList = new ArrayList<String>();
        String name;
        String input;
        input  = scnr.nextLine();
        while(!input.equals("-1"))
        {
            StringTokenizer strToken = new StringTokenizer();
            while(strToken.hasMoreElements()) {
                String firstName = strToken.nextToken();
                nameList.add(firstName);
            }
            }
        }

        allPermutations(permList,nameList);
        // TODO: Read in a list of names; stop when -1 is read. Then call recursive method.
    }
*/
