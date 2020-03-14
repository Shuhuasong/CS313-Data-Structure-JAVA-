public class CompareToExample {
    public static void main(String[] args){
        String str1 ="String method tutorial";
        String str2 = "compareTo method example";
        String str3 = "String method tutorial";

        int var1 = str1.compareTo(str2);
        int var2 = str1.compareTo(str3);
        int var3 = str2.compareTo(str1);
        System.out.println("Str1 & Str3 comparison: " + var2);
        System.out.println("Str2 & Str1 comparison: " + var3);

        //find length of a string using String compareTo() method
        //compare a string with an empty string using the compareTo() method then the method would return the length of the non-empty string.
        String str4 = "";
        int length = str1.compareTo(str4);
        System.out.println("the length of Str1 is: "+ length);
    }
}
