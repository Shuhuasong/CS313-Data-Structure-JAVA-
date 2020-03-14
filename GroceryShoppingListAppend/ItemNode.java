package GroceryShoppingListAppend;

public class ItemNode {
    private String item;
    private ItemNode nextNodeRef; // Reference to the next node

    public ItemNode() {
        item = "";
        nextNodeRef = null;
    }

    // Constructor
    public ItemNode(String itemInit) {
        this.item = itemInit;
        this.nextNodeRef = null;
    }

    // Constructor
    public ItemNode(String itemInit, ItemNode nextLoc) {
        this.item = itemInit;
        this.nextNodeRef = nextLoc;
    }

    // Insert node after this node.
    public void insertAfter(ItemNode nodeLoc) {
        ItemNode tmpNext;

        tmpNext = this.nextNodeRef;
        this.nextNodeRef = nodeLoc;
        nodeLoc.nextNodeRef = tmpNext;
    }

    public void insertAtEnd(ItemNode headNode,ItemNode newNode){
        ItemNode currentNode;
        currentNode = headNode;
        while(currentNode.nextNodeRef!=null){
            currentNode = currentNode.nextNodeRef;
        }
        currentNode.insertAfter(newNode);
    }

    // TODO: Define insertAtEnd() method that inserts a node
    //       to the end of the linked list


    // Get location pointed by nextNodeRef
    public ItemNode getNext() {
        return this.nextNodeRef;
    }

    public void printNodeData() {
        System.out.println(this.item);
    }
}