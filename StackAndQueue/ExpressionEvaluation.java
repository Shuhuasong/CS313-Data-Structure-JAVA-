package StackAndQueue;

import java.util.Stack;

import java.util.*;
import java.util.Scanner;

class Main
{
    public static boolean hasPrecedence(char op1, char op2){
        if(op2 == '(' || op2 == ')')
            return false;
        if((op1 == '*' || op1 == '/') && (op2 =='+' || op2 == '-'))
            return false;
        else
            return true;
    }
    public static double applyOp(char op,double a, double b){
        switch(op){
            case '+':
                return a + b;
            case '-':
                return b - a;//order
            case '*':
                return a * b;
            case '/':
                if(b==0)
                    throw new UnsupportedOperationException("Cannot divide by zero");
                return b / a;

        }
        return 0;
    }

    public static  double evaluate(String expr) throws EmptyStackException  {
        //Add code below
        char[] tokens = expr.toCharArray();
        Stack<Double> values = new Stack<Double>();
        Stack<Character> operator = new Stack<Character>();

        for (int i = 0; i < tokens.length; i++) {
            //if(values.size()!=0)
            //System.out.println(values);
            if (tokens[i] == ' ')
                continue;
            if (tokens[i] >= '0' && tokens[i] <= '9') { //there are more than one number, for example: 34
                StringBuffer strBuff = new StringBuffer();
                //for more than digits in number
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9' || tokens[i] == '.')
                    strBuff.append(tokens[i++]);
                //System.out.println(Double.parseDouble(strBuff.toString()));
                values.push(Double.parseDouble(strBuff.toString()));
            } else if (tokens[i] == '(') {
                operator.push(tokens[i]);
            }
            //Closing brace encountered, solve entire brace
            else if (tokens[i] == ')') {

                while (operator.peek() != '(' && !operator.empty() && values.size() >= 2)  //&& values.size() >= 2)

                    values.push(applyOp(operator.pop(), values.pop(), values.pop()));
                operator.pop();


                //throw new EmptyStackException();
            }
            //Current token is an operator
            else if (tokens[i] == '+' || tokens[i] == '-' ||
                    tokens[i] == '*' || tokens[i] == '/') {

                //while (!operator.empty() && values.size() >= 2 )
                //values.push(applyOp(operator.pop(), values.pop(), values.pop()));
                // catch(EmptyStackException e) {return 0.0; }
                //System.out.println(tokens[i]);
                operator.push(tokens[i]);
            }
        }

        while (!operator.empty()  && values.size() >= 2) {
            //System.out.println(applyOp(operator.pop(), values.pop(), values.pop()));
            values.push(applyOp(operator.pop(), values.pop(), values.pop()));


        }


        return values.pop();

    }
    /*
     * Sample main to run tests
     * *************************
     * Runs default tests if no
     * input is given.
     */
    public static void main(String[] args) throws EmptyStackException {
        //Variables
        Scanner scnr = new Scanner(System.in);
        //System.out.println("answer" + Main.evaluate("(4 * (3 + 6))"));
        //Custom test case
        if(scnr.hasNext()){
            String testInput = "";
            while(scnr.hasNext()){
                testInput = scnr.nextLine();
                //throw new EmptyStackException();
                System.out.println(testInput + " : " + evaluate(testInput));

            }
        }
        //Default test case
        else{
            String [] sampletests = {"(1+(2*3))", "(2*(4*(6/3)))","(3+(4*2))"};
            double [] sampleoutput = {7.0, 16.0, 11.0};
            for(int i = 0; i < sampletests.length; i++){
                if(evaluate(sampletests[i]) != sampleoutput[i]){
                    System.out.println("Failed sample tests");
                    return;
                }
            }
            System.out.println("Passed sample tests");
        }
    }
}