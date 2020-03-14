package OnlineShoppingCart2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class ShoppingCart {
    Scanner scnr = new Scanner(System.in);
    private String customerName;
    private String currentDate;
    ArrayList<ItemToPurchase> cartItems = new ArrayList<ItemToPurchase>();
    Iterator itr = cartItems.iterator();
    public ShoppingCart(){
        customerName = "none";
        currentDate = "January 1, 2019";
    }
    public ShoppingCart(String name, String date){
        customerName = name;
        currentDate = date;
    }

    public String getCustomerName(){ return customerName; }
    public String getDate() { return currentDate; }
    void setCustomerName(String name){ customerName = name;}
    void setDate(String date) { currentDate = date;}

    public void addItem(ItemToPurchase item){
        cartItems.add(item);

    }


    public void removeItem(String itemName){
        System.out.println("REMOVE ITEM FROM CART");
        System.out.println("Enter name of item to remove:");
        itemName = scnr.nextLine();
        int index = -1;

            for(int i=0; i<cartItems.size(); i++){
                if(cartItems.get(i).getName().equals(itemName))
                    index = i;
            }
            if(index!=-1)   { cartItems.remove(index); }
            else {  System.out.println("Item not found in cart. Nothing removed."); }

    }

    //???What it means If item can be found (by name) in cart, check if parameter has default values for description, price, and quantity. If not, modify item in cart.
    public void modifyItem(ItemToPurchase item){//Why this function didn't update the arrayList
        boolean found  = true;
        for(ItemToPurchase items: cartItems){
            if(items.getName().equalsIgnoreCase(item.getName())){
                if(items.getQuantity()!=0){
                    items.setQuantity(item.getQuantity());
                }
            }
        }
        if(!found) {
            System.out.println("Item not found in cart. Nothing removed");
        }
    }

    public int getNumItemsInCart(){

        if(cartItems.isEmpty()){
            return 0;
        }

        return cartItems.size();
    }

    public int getCostOfCart(){
        //System.out.println(" Get Cost Of Cart");
        int totalCost = 0;
        int itemNum = 0;
        int itemPrice = 0;
        if(cartItems.size()<0) return 0;
        for(int i=0; i<cartItems.size();i++){
            itemNum = cartItems.get(i).getQuantity();
            itemPrice = cartItems.get(i).getPrice();
            totalCost += itemNum * itemPrice;
        }
        return totalCost;
    }

    public void printTotal(){

        System.out.println("OUTPUT SHOPPING CART");
        System.out.println(customerName+"'s Shopping Cart - "+ currentDate);
        System.out.println("Number of Items: " + getNumItemsInCart()+"\n");

        if(cartItems.size()<0) {
            System.out.println("SHOPPING CART IS EMPTY\n");
        }
        for(int i=0; i<cartItems.size(); i++){

                cartItems.get(i).printItemCost();
        }
        System.out.println("\n"+"Total: $" + getCostOfCart());

    }

    public void printDescription(){
        System.out.println("OUTPUT ITEMS' DESCRIPTIONS");
        System.out.println(customerName+"'s Shopping Cart - "+ currentDate);
        System.out.println();
        System.out.println("Item Descriptions");

            for(int i=0; i<cartItems.size();i++){   ///Why it print out null for both????
                cartItems.get(i).printItemDescription();
            }
    }

}
