package OnlineShoppingCart2;

public class ItemToPurchase {
    private  String itemName;
    private int itemPrice;
    private int itemQuantity;
    private String itemDescription;

    public ItemToPurchase()
    {
        itemName = "none";
        itemPrice = 0;
        itemQuantity = 0;
        itemDescription = "none";
    }

    public ItemToPurchase(String name,String description, int price, int quantity){
        itemName = name;
        itemPrice = price;
        itemQuantity = quantity;
        itemDescription = description;
    }

    public void setName(String name){ itemName = name; }
    public void setPrice(int price) { itemPrice = price; }
    public void setQuantity(int quantity) { itemQuantity = quantity; }
    public void setDescription(String description) { itemDescription = description; }
    String getName() { return itemName; }
    int getPrice() { return itemPrice; }
    int getQuantity() { return itemQuantity; }
    String getDescription() { return itemDescription; }

    public void printItemCost(){
        System.out.println(itemName +" "+ itemQuantity+" @  $"+ itemPrice +" = "+ (itemQuantity*itemPrice));
    }

    public void printItemDescription(){
        System.out.println(itemName + ": " + itemDescription);
    }
}
