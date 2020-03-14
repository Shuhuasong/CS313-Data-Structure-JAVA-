package MapAndSet;

import java.util.HashMap;
import java.util.Map;

public class DictionaryPractice {

    public static void main(String[] args){
        Map<String, String> englSpanDictionary = new HashMap<String, String>();
        //putting item inside of the dictionay
        englSpanDictionary.put("Monday", "Lunes");
        englSpanDictionary.put("Tuesday", "Martes");
        englSpanDictionary.put("Wednesday", "Miercoles");
        englSpanDictionary.put("Thursday", "Jueves");
        englSpanDictionary.put("Friday", "Viernes");
        englSpanDictionary.put("Saturday", "Sabado");
        englSpanDictionary.put("Sunday", "Domingo");
        //Retrieve things from our dictionary
        System.out.println(englSpanDictionary.get("Monday"));
        System.out.println(englSpanDictionary.get("Tuesday"));
        System.out.println(englSpanDictionary.get("Wednesday"));
        System.out.println(englSpanDictionary.get("Thursday"));
        System.out.println(englSpanDictionary.get("Friday"));
        System.out.println(englSpanDictionary.keySet());
        System.out.println(englSpanDictionary.values());
        System.out.println("The size of our dictionary is " + englSpanDictionary.size());

        System.out.println();
        System.out.println();

        //Shopping List
        Map<String, Boolean> shoppingList  = new HashMap<String, Boolean>();
        shoppingList.put("ham", true);
        shoppingList.put("Bread", true );
        shoppingList.put("Onion",Boolean.TRUE);
        shoppingList.put("Egg", Boolean.FALSE);
        shoppingList.put("Suggar", false);
        //Retrieve items
        System.out.println(shoppingList.get("Sugar"));
        //Key-value Pairs Print Out
        System.out.println(shoppingList.toString());
        //Is Empty?
        System.out.println(shoppingList.isEmpty());
        //Clear our dictionary
        //shoppingList.clear();//set the disctionary pointer point to the empty dictionary
        //replace values for a certain key
        shoppingList.replace("Bread", Boolean.FALSE);
        System.out.println(shoppingList.toString());
    }


}
