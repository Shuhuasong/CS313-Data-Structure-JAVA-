package Contacts;

import java.util.Scanner;

public class ContactList {



    public ContactNode head = null;
    public ContactNode tail = null;
    int size = 0;

//    public static ContactList insertAfter(ContactList list, String newName, String newPhone)
//    {
//        ContactNode newNode = new ContactNode(newName,newPhone);
//        newNode.nextNodePtr = null;
//
//        if(list.head == null){
//            list.head = newNode;
//        }
//        else{
//            ContactNode last = list.head;
//            while(last.nextNodePtr != null){
//                last = last.nextNodePtr;
//            }
//            last.nextNodePtr = newNode;
//        }
//        return list;
//    }

//    public void append(ContactNode newNode)
//    {
//        if(head == null){
//            head = newNode;
//        }
//        ContactNode current;
//        current = head;
//        while(current.nextNodePtr!=null){
//            current = current.nextNodePtr;
//        }
//        current.nextNodePtr = newNode;
//
//    }

    public String toString(){
        String resStr = "CONTACT LIST ";

        ContactNode current = head;
        while(current != null){
            resStr += "\nName: " + current.getName() + "\n";
            resStr += "Phone number: " + current.getContactPhoneNumber()+ "\n";
            current = current.getNext();
        }
        return resStr;
    }

//    public static void printList(ContactList conList, int size){
//        ContactNode current =conList.head;
//        System.out.println("CONTACT LIST");
//        while(current!=null){
//            current = current.nextNodePtr;
//            current.printContactNode();
//        }
//
//    }


    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        ContactList conList = new ContactList();
        ContactNode current = new ContactNode();
        current = conList.head;
        int numPerson = 1;
        int count = 1;
        String name;
        String phoneNumber;
        while(numPerson<=3){
            System.out.println("Person " +  count++);
            System.out.println("Enter name: ");
            name = scnr.nextLine();
            System.out.println("Enter phone number: ");
            phoneNumber = scnr.nextLine();
            //ContactNode newNode = new ContactNode(name, phoneNumber);
            System.out.println("You entered: " + name + ", " + phoneNumber);
            System.out.println();
            if(conList.head==null){
                ContactNode newNode = new  ContactNode(name, phoneNumber);
                //if(newNode.getContactPhoneNumber().equals("555-555-5555"))
                conList.head = newNode;
                numPerson++;
                conList.tail = conList.head;
            }
            else{
                ContactNode node = new ContactNode(name, phoneNumber);
                conList.tail.insertAfter(name, phoneNumber);
                conList.tail = node;
                numPerson++;
            }
//            current.inserAfter(name, phoneNumber);
//            current = current.getNext();
            //numPerson++;
            //current = current.getNext();

//                conList.tail.inserAfter(name, phoneNumber);
//                numPerson++;
//
        }
        //System.out.println();

        System.out.println(conList.toString());
        // printList(conList, numPerson);


        /* Type your code here. */
    }


}
