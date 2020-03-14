import java.util.Scanner;
import java.util.InputMismatchException;
//the difference between next() and nextLine()
public class NameAgeChecker {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        String inputName;
        int age = 0;

        inputName = scnr.next();
        while (!inputName.equals("-1")) {
            // FIXME: The following line will throw an InputMismatchException.
            //        Insert a try/catch statement to catch the exception.

                if(!scnr.hasNextInt()){
                    try{
                         age = 0;
                    }catch (InputMismatchException e){
                        System.out.println("Invalid age");
                    }
                }


            age = scnr.nextInt();
            System.out.println(inputName + " " + (age + 1));
            inputName = scnr.next();
        }
    }
}