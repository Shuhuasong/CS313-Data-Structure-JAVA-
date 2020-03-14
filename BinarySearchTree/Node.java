package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class Node {
    Node left, right;
    int data;

    public Node(int data) {
        this.data = data;
    }

    public class BinaryTree{
        Node left, rigth;
    }

    public void insert(int value) {
        if (value <= data) {
            if (left == null) {
                left = new Node(value);
            }else{
                left.insert(value);
            }
        }else{
            if(right == null){
                right = new Node(value);
            }else{
                right.insert(value);
            }
        }
    }

    public boolean contains(int value){
        if(value == data) return true;
        else if(value < data){
            if(left==null){ return false; }
            else {  return left.contains(value); }
        }else{
            if(right == null){
                return false;
            }else{
                return right.contains(value);
            }
        }
    }

    public void printInOrder() {
        if(left != null) { left.printInOrder(); }
        System.out.println(data);
        if(right != null) { right.printInOrder(); }
    }

    void printPreorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " "); // process node
        printPreorder(node.left); // recurse on left
        printPreorder(node.right); // recrse on right
    }

    void printPostorder(Node node) {
        if (node == null) {
            return;
        }
        printPostorder(node.left); // recurse on left
        printPostorder(node.right); // recurse on right
        System.out.println(node.data + " "); // process node
    }

    void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left); // process left
        System.out.println(node.data); // process node
        printInorder(node.right); // process right
    }

    public void printBFS(Node root) {
        Queue<Node> queue = new LinkedList<Node>();

        if (root == null)
            return;
        queue.clear();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.remove();
            System.out.print(node.data + " ");
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }

    }

    public boolean doesNodeExistInBST(Node bstRoot, int searchValue) {
        // if we've ran out of values to search for, return false
        if (bstRoot == null) {
            return false;
        } else if (bstRoot.data == searchValue) {
            return true;
        } else {
            // if the node we're at is smaller than the value we're looking for, traverse on the right side
            if (searchValue > bstRoot.data) {
                return doesNodeExistInBST(bstRoot.right, searchValue);
            } else {
                // if the node we're at is bigger than the value we're looking for, traver the left side
                return doesNodeExistInBST(bstRoot.left, searchValue);
            }
        }
    }

    int getBinaryTreeHeight(Node node) {
        if (node == null) {
            return -1;
        }

        int leftHeight = getBinaryTreeHeight(node.left);
        int rightHeight = getBinaryTreeHeight(node.right);

        if (leftHeight > rightHeight) {
            return leftHeight + 1;
        } else {
            return rightHeight + 1;
        }
    }


    public static Node  getLargest(Node node) {
        if (node.right != null) {
            return getLargest(node.right);
        }
        return node;
    }




    public static Node getSecondLargest(Node node) {

        // we are looking at the right-most element
        // (aka largest) and it has a left child
        // so we want the largest element in its left child
        if (node.right == null && node.left != null) {
            return getLargest(node.left);
        }

        // we are looking at the parent of the largest element
        // and the largest element has no children
        // so this is the node we want
        if (node.right != null &&
                node.right.left == null &&
                node.right.right == null) {
            return node;
        }

        // recurse on the right child until we match
        // one of the above cases
        return getSecondLargest(node.right);
    }

}
