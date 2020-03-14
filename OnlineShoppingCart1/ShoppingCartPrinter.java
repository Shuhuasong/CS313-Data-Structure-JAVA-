package OnlineShoppingCart1;

import java.util.Scanner;

public class ShoppingCartPrinter {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String name1,name2;
        int price1, price2;
        int quantity1, quantity2;
        int totalPrice;
        //int count =0;

        System.out.println("Item 1");
        System.out.println("Enter the item name:");
        name1 = scnr.nextLine();
        System.out.println("Enter the item price:");
        price1 = scnr.nextInt();
        System.out.println("Enter the item quantity:");
        quantity1 = scnr.nextInt();
        ItemToPurchase item1 = new ItemToPurchase(name1, price1, quantity1);
        scnr.nextLine();
        System.out.println();
        System.out.println("Item 2");
        System.out.println("Enter the item name:");
        name2 = scnr.nextLine();
        System.out.println("Enter the item price:");
        price2 = scnr.nextInt();
        System.out.println("Enter the item quantity:");
        quantity2 = scnr.nextInt();
        ItemToPurchase item2 = new ItemToPurchase(name2, price2, quantity2);
        totalPrice = price1 * quantity1 + price2 * quantity2;
        System.out.println();
        System.out.println("TOTAL COST");
        System.out.println(name1 + " " + quantity1 + " @" +" $"+ price1 + " = " +"$"+ price1 * quantity1);
        System.out.println(name2 + " " + quantity2 + " @" +" $"+ price2 + " = " +"$"+ price2 * quantity2);
        System.out.println();
        System.out.println("Total: $" + totalPrice);
        /* Type your code here. */
    }
}
