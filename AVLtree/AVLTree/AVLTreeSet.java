package AVLtree.AVLTree;


import java.util.*;

public class bnAVLTreeSet<E extends Comparable<E>> implements Set<E> {
    //E must be a class that imlements Comparable
    private Node<E> root;

    //Constructor a new empty tree
    public AVLTreeSet(){ }

    //Adds the specified element to the tree
    public void add(E e){
        root = add(e, root);
    }

    //Adds the specified element to the tree(if it is not already in the tree) and returns the root;
    private Node<E> add(E e, Node<E> root){
        if(root == null) return new Node<>(e);
        int compare  = e.compareTo(root.data);
        if(compare < 0){
            root.left = add(e, root.left);
        }else if(compare > 0){
            root.right = add(e, root.right);
        }
        root.updateHeightAndBF();
        return rebalance(root);
    }

    //Rebalance the subtree if it is unbalanced with a single or double rotation
    private Node<E> rebalance(Node<E> root) {
        if(root.bf == -2){   //left-left or left-right case
            if(root.left.bf == 1)  // left-right case
                root.left = rotateLeft(root.left);
            return rotateRight(root);
        }else if(root.bf == 2){ //Right-left case
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }
        return root;
    }

    //Performs a left rotation, updates the heights, and returns the new root of the subtree
    private Node<E> rotateLeft(Node<E> left) {
        Node<E> right = root.right;
        root.right = right.left;
        right.left = root;
        root.updateHeightAndBF();
        right.updateHeightAndBF();
        return right;
    }

    //Perform a right rotation, updates the heights, and returns the root of the substree
    private Node<E> rotateRight(Node<E> root) {
        Node<E> left = root.left;
        root.left = left.right;
        left.right = root;
        root.updateHeightAndBF();
        left.updateHeightAndBF();
        return left;
    }

    //remove the specified element from the tree(if it is in the tree;
    public void remove(E e){
        root = remove(e, root);
    }

    //remove the specified element from the tree and returns the root
    private Node<E> remove(E e, Node<E> root){
        if(root == null) return null;      // Case where the tree is empty
        int compare = e.compareTo(root.data);
        if(compare < 0)                     //if e < root.data, remove it from the left subtree.
            root.left = remove(e, root.left);
        else if(compare > 0){               //if e > root.data,, remove it from the right substree;
            root.right = remove(e, root.right);
        }
        else{                               // if e == root.data
            if(root.left == null) return root.right;    //Case with 0 or 1 substree(right)
            else if(root.right == null) return root.left; // Case with 1 Substree(left)
            Node<E> t = root.right;                       // Case with s substree
            while(t.left != null) t =  t.left;            // Find the successor (min element in the right substree)
            root.data = t.data;                             //replace root.data with min value in right substree
            root.right = remove(t.data, root.right);      //remove the min value from right subtree
        }
        root.updateHeightAndBF();                           //update the root's height and balance factor
        return rebalance(root);                             //rebalance the substree if it is unblanced
    }

    //returns ture if the tree constains the specified element
    public boolean contains(E e){
        return contains(e, root);
    }
    //returns true if the tree contains the specified elemnent
    private boolean contains(E e, Node<E> root){
        if(root == null) return false;
        int compare = e.compareTo(root.data);
        if(compare < 0)
            return contains(e, root.left);
        else if(compare > 0)
            return contains(e, root.right);
        return true;
    }

    //Print the tree pre-order wiht indentation
    public void preOrderIndented() {
        preOrderIndented(root, " ");
    }

    private void preOrderIndented(Node<E> n, String indent){
        if(n == null) return;
        System.out.println(indent + n.data + "(h = " + n.height + ",bf= "+n.bf + ")");
        preOrderIndented(n.left, indent + " ");
        preOrderIndented(n.right, indent + " ");
    }

    private static class Node<E extends Comparable<E>> {
        E data;
        Node<E> left = null, right = null;
        //bf (Balance factor) is the height of the right substree - the height of the left subtree
        int height = 0;
        int bf = 0;

        Node(E data){
            this.data = data;
        }

        void updateHeightAndBF() {
            int leftHeight = left == null ? -1: left.height;
            int rightHeight = right == null? -1: right.height;
            height = 1 + Math.max(leftHeight, rightHeight);
            bf = rightHeight - leftHeight;
        }
    }

    private class Itr implements Iterator<E> {
        Deque<Node<E>> stack = new ArrayDeque<>();

        Itr() {
            pushLeftPath(root);
        }

        public boolean hasNext(){
            return !stack.isEmpty();
        }

       public E next() {
            Node<E> next = stack.pop();
            pushLeftPath(next.right);
            return next.data;
       }

       private void pushLeftPath(Node<E> n){
            while(n!=null){
                stack.push(n);
                n = n.left;
            }
       }

       public void remove(){
            throw new UnsupportedOperationException();
       }
    }

}



