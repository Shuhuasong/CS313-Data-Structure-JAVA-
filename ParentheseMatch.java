import java.util.*;
import java.util.Scanner;

public class ParentheseMatch {
    public static boolean isMatchingPair(char char1, char char2){
        if(char1 == '(' && char2 == ')') return true;
        else if (char1 == '[' && char2 == ']') return true;
        else
            return false;
    }

    static boolean isValid(String s){
        //Add code below
        Stack<Character> stack= new Stack<Character>();

        char[] chars = s.toCharArray();
        int length = s.length();
        for(int i=0; i<length; i++){
            if(chars[i] == '(' || chars[i] == '[')
                stack.push(chars[i]);
            if(chars[i] == ')' || chars[i] == ']'){
                if(stack.isEmpty()){
                    return  false;
                }
                else if(!isMatchingPair(stack.pop(), chars[i])){
                    return false;
                }
            }
        }
        if(stack.isEmpty() || s.isEmpty())
        {
            return true;
        }
        else{
            return false;
        }
        //Add code below


    }
    /*
     * Sample main to run tests
     * *************************
     * Runs default tests if no
     * input is given.
     */
    public static void main(String[] args){
        //Variables
        Scanner scnr = new Scanner(System.in);
        //Custom test case
        if(scnr.hasNext()){
            String testInput = "";
            while(scnr.hasNext()){
                testInput = scnr.nextLine();
                System.out.println(testInput + " : " + isValid(testInput));
            }
        }
        //Default test case
        else{
            String [] sampletests = {"(lo[ef]fejefd)", "(ad(d23(efe[ef][2][3])[])[)","([([([welcome])hi])])}"};
            boolean [] sampleoutput = {true,false,true};
            for(int i = 0; i < sampletests.length; i++){
                if(isValid(sampletests[i]) != sampleoutput[i]){
                    System.out.println("Failed sample tests");
                    return;
                }
            }
            System.out.println("Passed sample tests");
        }
    }
}
