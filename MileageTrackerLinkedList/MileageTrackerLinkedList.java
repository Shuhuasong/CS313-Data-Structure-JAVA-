package MileageTrackerLinkedList;

import java.util.Scanner;

public class MileageTrackerLinkedList {


//    public static void printSong(MileageTrackerNode head){
//        MileageTrackerNode currentNode;
//        currentNode = head.getNext();
//        while(currentNode!=null){
//            currentNode.printNodeData();
//            currentNode = currentNode.getNext();
//        }
//    }



    public static void main (String[] args) {
        Scanner scnr = new Scanner(System.in);

        // References for MileageTrackerNode objects
        MileageTrackerNode headNode;
        MileageTrackerNode currNode;
        MileageTrackerNode lastNode;

        double miles;
        String date;
        int i;

        // Front of nodes list
        headNode = new MileageTrackerNode();
        lastNode = headNode;


        // TODO: Scan the number of nodes

//        int input = scnr.nextInt();

        // TODO: For the scanned number of nodes, scan
        //       in data and insert into the linked list

//        for(i=0; i<input; i++){
//            miles = scnr.nextDouble();
//            date = scnr.next();
//            currNode = new  MileageTrackerNode(miles, date);
//            lastNode.insertAfter(currNode);
//            lastNode = currNode;
//        }

        // TODO: Call the printNodeData() method
        //       to print the entire linked list

//        currNode = headNode.getNext();
//        while(currNode!= null){
//            currNode.printNodeData();
//            currNode = currNode.getNext();
//        }


        // TODO: Scan the number of nodes
        int input = scnr.nextInt();

        // TODO: for the scanned number of nodes, scan
        // in data and insert into the linked list
        for (i = 0; i < input; i++) {
            miles = scnr.nextDouble();
            date = scnr.next();
            currNode = new MileageTrackerNode(miles, date);

            lastNode.insertAfter(currNode);
            lastNode = currNode;
        }

        // TODO: Call the printNodeData() method
        // to print the entire linked list
        currNode = headNode.getNext();
        while (currNode != null) {
            currNode.printNodeData();
            currNode = currNode.getNext();
        }
    }

}