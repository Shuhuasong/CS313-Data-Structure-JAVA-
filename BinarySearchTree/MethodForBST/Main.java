package BinarySearchTree.MethodForBST;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BSTSet<Integer> bt1 = new BSTSet<Integer>(), bt2 = new BSTSet<Integer>();
        Scanner scnr = new Scanner(System.in);
        if (scnr.hasNextLine()) {
            try {
                ArrayList<Integer> arr1 = new ArrayList<Integer>(),
                        arr2 = new ArrayList<Integer>();
                String[] in1 = scnr.nextLine().split("\\s");
                String[] in2 = scnr.nextLine().split("\\s");
                for (String s : in1)
                    bt1.add(Integer.parseInt(s));
                for (String s : in2)
                    bt2.add(Integer.parseInt(s));
            } catch (java.util.NoSuchElementException nse) {
                System.out.println("*******Warning*******\n  No input given for\n   one or both BSTs\n*********************");
            } catch (Exception ex) {
                ex.printStackTrace();
                return;
            }
        } else {
            int testArr[] = {6, 2, 3, 4, 5, 1, 2, 4, 2};
            for (int i : testArr) {
                bt1.add(i);
                bt2.add(i);
            }
            bt1.add(1);
            bt2.add(10);
        }
        System.out.println("bt1 contains 5: " + bt1.contains(5));
        System.out.println("bt1 minimum is: " + bt1.minimum(bt1.root));
        System.out.println("bt1 height is: " + bt1.height(bt1.root));
        System.out.println("\nbt2 contains 5: " + bt2.contains(5));
        System.out.println("bt2 minimum is: " + bt2.minimum(bt2.root));
        System.out.println("bt2 height is: " + bt2.height(bt2.root));
        System.out.println("\nbt1 == bt2: " + bt1.sameTree(bt1.root, bt2.root));
        System.out.println("bt1 is proper BST: " + bt1.isBST());
        System.out.println("bt2 is proper BST: " + bt2.isBST());

    }
}
