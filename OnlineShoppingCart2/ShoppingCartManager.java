package OnlineShoppingCart2;

import java.util.Scanner;

public class ShoppingCartManager {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        //ItemToPurchase newItem = new ItemToPurchase();
        String custName, date;
        String itemName = "";
        char option=' ';
        System.out.println("Enter Customer's Name:");
        custName = scnr.nextLine();
        System.out.println("Enter Today's Date:");
        date = scnr.nextLine();
        System.out.println();
        System.out.println("Customer Name: " + custName);
        System.out.println("Today's Date: " + date);
        System.out.println();
        ShoppingCart cart = new ShoppingCart(custName, date);
        while(option!='q'){
            System.out.println("MENU");
            System.out.println("a - Add item to cart\n" +
                    "d - Remove item from cart\n" +
                    "c - Change item quantity\n" +
                    "i - Output items' descriptions\n" +
                    "o - Output shopping cart\n" +
                    "q - Quit\n");
            System.out.println("Choose an option:");

            option = scnr.nextLine().charAt(0);
            switch (option) {
                case 'a':{
                    String name, description;
                    int price, quantity;
                    System.out.println("ADD ITEM TO CART");
                    System.out.println("Enter the item name:");
                    name = scnr.nextLine();
                    System.out.println("Enter the item description:");
                    description = scnr.nextLine();
                    System.out.println("Enter the item price:");
                    price = scnr.nextInt();
                    System.out.println("Enter the item quantity:");
                    quantity = scnr.nextInt();
                    scnr.nextLine(); //!!!
                    ItemToPurchase item = new ItemToPurchase(name, description, price, quantity);
                    cart.addItem(item);
                   }

                    break;
                case 'd':
                    cart.removeItem(itemName);
                    break;
                case 'c':
                    System.out.println("CHANGE ITEM QUANTITY");
                    System.out.println("Enter the item name:");
                    String name = scnr.nextLine();
                    System.out.println("Enter the new quantity:");
                    int newQuantity = scnr.nextInt();
                    scnr.nextLine();
                    ItemToPurchase item = new ItemToPurchase();
                    item.setName(name);
                    item.setQuantity(newQuantity);
                    cart.modifyItem(item);
                    break;
                case 'i':
                    cart.printDescription();
                    break;
                case 'o':
                    cart.printTotal();
                    break;
                default:
                    System.exit(0);
                    break;
        }

        }
        System.exit(0);

    }
}

/*
 John Doe
 February 1, 2016
 */