package PolynomialArithmetic;

import java.util.StringTokenizer;

public class Parser {
    public static void main(String[] args) {
        String s = "X^4  - 2.88 X^2  + 3.0";
        String parts[] = s.replace(" ","").split("(?=\\+|\\-)");
        for(int i=0; i<parts.length; i++){
            System.out.println(parts[i]);
            Term result = parse(parts[i]);
            testStringTokenizer(parts[i]);
            // System.out.println("coeff:" + result[0] + " power: "+ result[1]);
            //System.out.println("coeff:" + result.getCoefficient() + " power: "+ result.getDegree());
        }
        //int result = parse("-55x^5");

    }

    public static void testStringTokenizer(String s){
        String delimeter = "^xX";
        StringTokenizer strToken = new StringTokenizer(s,delimeter,true);
        while(strToken.hasMoreTokens()){
            System.out.println(strToken.nextToken());
        }
    }

        public static Term parse(String s){
            double coefficient = 0.0;
            int power = 0;
            boolean isNegative=false;
            String delimeter = "^xX";
            StringTokenizer strToken = new StringTokenizer(s,delimeter,true);
            String  newToken = strToken.nextToken();
            if(newToken.equals("+")) { isNegative = false;  newToken = strToken.nextToken(); }
            if(newToken.equals("-")) {  isNegative = true; newToken = strToken.nextToken();}

            if(newToken.equals("x")|| newToken.equals("X")){
                if(isNegative) coefficient = -1.0;
                else coefficient = 1.0;
                if(!strToken.hasMoreTokens())  power = 1;
                else{
                    strToken.nextToken();
                    power = Integer.parseInt(strToken.nextToken());
                }
            }
            else{
                coefficient = Double.parseDouble(newToken);
                if(isNegative==true){
                    coefficient =-coefficient;
                    System.out.println("coefficient: "+ coefficient);
                }
                if(!strToken.hasMoreElements()){
                    power = 0;
                }
                else{
                    strToken.nextToken();
                    if(!strToken.hasMoreTokens()){
                        power =1;
                    }
                    else{
                        strToken.nextToken();
                        power = Integer.parseInt(strToken.nextToken());
                    }
                }
            }
            Term term = new Term(coefficient, power);
            return term;

        }


    /*public static Term parse(String s){

        double coefficient = 0;
        int power = 0;
        int index = 0;
        boolean isNegative=false;
        boolean foundDigit = false;
        int val= 0;
        if(s.charAt(0)=='-'){
            isNegative = true;
            index++;
        }
        else if(s.charAt(0)=='+'){
            isNegative = false;
            index++;
        }
        while(index < s.length() && Character.isDigit(s.charAt(index)) ){
            val = val * 10 + s.charAt(index) - '0';
            foundDigit = true;

            index++;
        }
        if(foundDigit)
        {
            if(isNegative){
                coefficient = -val;
            }else{
                coefficient = val;
            }

        }
        else{
            coefficient = 1.0;
        }
        if(index == s.length() - 1 && s.charAt(index)=='X') power = 1;
        //if(s.isEmpty()){power = 1; }
        //skip X
        index++;
        //skip ^
        index++;


        while(index < s.length() && Character.isDigit(s.charAt(index))){
            int degree = 0;
            degree = degree * 10 + s.charAt(index) - '0';
            index++;
            //System.out.println("Degree: "+degree);
            power = degree;
        }

        Term newTerm = new Term(coefficient, power);
        return newTerm;
    }

    /*static int[] parse(String input){
        int coeff = 0;
        int power = 0;
        int index = 0;
        int[] pair = getDigits(index,input, true);
        index = pair[0];
        coeff = pair[1];
        if(index == input.length()) return new int[]{coeff,power};
        index++; // skip x
        index++; // skip ^
        pair = getDigits(index, input, false);
        index = pair[0];
        power = pair[1];
        if(power == 0 && coeff > 0) power = 1;
        return new int[]{coeff, power};
    }

    private static int[] getDigits(int index , String input, final boolean findCoeff){
        int val = 0;

        while(index < input.length() && Character.isDigit(input.charAt(index))){ // for the 15x^4 case
            val = val * 10 + (input.charAt(index) - '0');
            index++;
        }
        if(val == 0 && findCoeff) val = 1; // for the x^4 case
        return new int[]{index, val};
    }*/

    /*public static int[] parse(String s){

        int coefficient = 0;
        int power = 0;
        int index = 0;
        boolean foundDigit = false;
        int val= 0;
        //if(s.charAt(0).equals("-"))
        while(index < s.length() && Character.isDigit(s.charAt(index))){
            val = val * 10 + s.charAt(index) - '0';
            foundDigit = true;
            index++;
        }
        coefficient = foundDigit ? val : 1;
        if(index == s.length()) power = 1;
        index++;
        index++;
        int degree = 0;
        while(index < s.length() && Character.isDigit(s.charAt(index))){
            degree = degree * 10 + s.charAt(index) - '0';
            index++;
        }
        power = degree;
        //Term newTerm = new Term(coefficient, power);
        return new int[] {coefficient, degree};
    }
    */

    /*public static int[] parse(String s){

        int coefficient = 0;
        int power = 0;
        int index = 0;
        boolean foundDigit = false;
        int val= 0;
        //if(s.charAt(0).equals("-"))
        while(index < s.length() && Character.isDigit(s.charAt(index))){
            val = val * 10 + s.charAt(index) - '0';
            foundDigit = true;
            index++;
        }
        coefficient = foundDigit ? val : 1;
        if(index == s.length()) power = 1;
        index++;
        index++;
        int degree = 0;
        while(index < s.length() && Character.isDigit(s.charAt(index))){
            degree = degree * 10 + s.charAt(index) - '0';
            index++;
        }
        power = degree;
        //Term newTerm = new Term(coefficient, power);
        return new int[] {coefficient, degree};
    }*/
    /*public static int[] parse(String s){

        int coefficient = 0;
        int power = 0;
        int index = 0;
        boolean isNegative=false;
        boolean foundDigit = false;
        int val= 0;
        if(s.charAt(0)=='-'){
            isNegative = true;
            index++;
        }
        while(index < s.length() && Character.isDigit(s.charAt(index))){
            val = val * 10 + s.charAt(index) - '0';
            foundDigit = true;
            index++;
        }
        if(foundDigit)
        {
            if(isNegative){
                coefficient = -val;
            }else{
                coefficient = val;
            }

        }
        else{
            coefficient = 1;
        }
        if(index == s.length()) power = 1;
        index++;
        index++;
        int degree = 0;
        while(index < s.length() && Character.isDigit(s.charAt(index))){
            degree = degree * 10 + s.charAt(index) - '0';
            index++;
        }
        power = degree;
        //Term newTerm = new Term(coefficient, power);
        return new int[] {coefficient, degree};
    }*/



    /*public static Term parse(String s) {
        Term term = new Term();
        if (s.equals("")) {
            return term;
        }
        if (!s.contains("x")) {
            term.setCoefficient(Double.valueOf(s));
            term.setDegree(0);
            return term;
        }
        StringBuilder coeff = new StringBuilder();
        StringBuilder power = new StringBuilder();
        int index = 0;
        while (s.charAt(index) != 'x') {
            coeff.append(s.charAt(index++));
        }
        index += 2; //move to the power term
        while (index < s.length()) {
            power.append(s.charAt(index++));
        }
        Double co = 1.0;
        int pwr = 1;
        try {
            co = Double.valueOf(coeff.toString());
        } catch (RuntimeException e) {
        }
        try {
            pwr = Integer.valueOf(power.toString());
        } catch (Exception e) {
        }
        term.setDegree(pwr);
        term.setCoefficient(co);
        return term;
    }*/



}


