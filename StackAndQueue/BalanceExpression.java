/*package StackAndQueue;

import java.util.Stack;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BalanceExpression {

    public static char[][] TOKENS = {{'{','}'}, {'{','}'}, {'{','}'}};

    public static boolean isOpenTerm(char c){
        for(char[] array : TOKENS) {
            if(array[0]==c){
                return true;
            }
        }
        return false;
    }

    public static boolean matches(char openTerm, char closeTerm){
        for(char[] array : TOKENS) {
            if(array[0] == openTerm){
                return array[1] == closeTerm;
            }
        }
    }
    public static boolean isBalance(String expression){
        Stack<Character> stack = new Stack<Character>;
        for(char c : expression.toCharArray()){
            if(isOpenTerm(c)){
                stack.push(c);
            }else{
                if(stack.isEmpty() || !matches(stack.pop(),c)){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
*/