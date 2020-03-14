package Contacts;

public class ContactNode {



    //private fields
    private String contactName;
    private String contactPhoneNumber;
    public ContactNode nextNodePtr;

    //Constructor
    public ContactNode(){
        contactName = "Jane Doe";
        contactPhoneNumber = "555-555-5555";
    };
    public ContactNode(String name, String phoneNumber)
    {
        contactName = name;
        contactPhoneNumber = phoneNumber;
    }


    //public method
    public String getName() { return contactName; }
    public String getContactPhoneNumber() { return contactPhoneNumber; }
    public ContactNode getNext() { return nextNodePtr; }

    // insertAfter

    public void insertAfter(String name, String phone){
        ContactNode tempNext = new ContactNode();
        tempNext = this.nextNodePtr;
        ContactNode newNode = new ContactNode(name, phone);
        this.nextNodePtr = newNode;
        newNode.nextNodePtr = tempNext;
    }
//    public void inserAfter(String name, String phone){
//        ContactNode  current = this;
//        while(current.getNext() != null){
//            current = current.getNext();
//        }
//        //ContactNode nextPointer = current.getNext();
//        current.nextNodePtr  = new ContactNode(name, phone);
//    }
    public void printContactNode()
    {

        System.out.println("Name: " + contactName);
        System.out.println("phoneNumber: " + contactPhoneNumber);
        System.out.println();
    }


    /*public void inserAfter(String newName, String newPhone, String curName) {
        ContactNode newNode =new ContactNode();
    }*/
    //https://stackoverflow.com/questions/37137350/linkedlist-insert-after-node
    //https://stackoverflow.com/questions/16127141/multiple-variables-stored-in-single-node-java-linked-list
}
