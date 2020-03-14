//Task 1: Regular Expression:
//https://www.vogella.com/tutorials/JavaRegularExpressions/article.html
//Task2: Split  https://www.geeksforgeeks.org/split-string-java-examples/
//Task3: Compparable & Comparator https://www.geeksforgeeks.org/comparable-vs-comparator-in-java/
package MostCommentWords;

public class Test {
    public static void main(String args[]){
        String s = "A user interface is like a joke. If you have to explain it, it's not that good.";

        String[] testInput = s.split("[\\s\t\n]");
        for(int i=0; i<testInput.length; i++){
            System.out.println(testInput[i] +" ");
            System.out.println(testInput[i].replaceAll("[^a-zA-Z\\d ]+$", ""));
            String[] parts=testInput[i].split(",");

                System.out.println(parts + " ");

        }
    }
}
