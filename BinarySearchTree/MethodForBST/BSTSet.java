package BinarySearchTree.MethodForBST;


import java.util.ArrayList;

// E must be a class that implements Comparable
public class BSTSet<E extends Comparable<E>> extends AbstractBSTSet<E> {
    /* **************************************************
     *
     *    You are provided the following attribute
     *    and implemented methods from AbstractBSTSet:
     *
     *    public Node<E> root;
     *    public void add(E e){};
     *    public void remove(E e) {};
     *
     * **************************************************/

    // Construct a new empty set
    public BSTSet() {
    }

    @Override
    public boolean contains(E e) {
        return contains(e, root);
    }

    // Returns true if the set contains the specified element.
    private boolean contains(E e, Node<E> root) {
        if (root == null) return false;
        else if (root.data == e) return true;
        int compare = e.compareTo(root.data);
        if (compare < 0) {
            return contains(e, root.left);
        } else if (compare > 0) return contains(e, root.right);

        // Implement the body of this method
        return false;
    }

    // Returns the minimum element in the BST
    public E minimum(Node<E> root) {
        if (root == null) return null;
        Node<E> t = root.left;
        while (t.left != null) t = t.left;
        return t.data;
        // Implement the body of this method
    }

    public E maxmum(Node<E> root) {
        if (root == null) return null;
        Node<E> t = root.right;
        while (t.right != null) t = t.right;
        return t.data;
    }

    // Returns the number of edges in the longest path from root to leaf
    public int height(Node<E> root) {
        if (root == null) return -1;
        if (root.left == null && root.right == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
        // Implement the body of this method
    }

    // Returns true if the compared trees have the exact same structure
    public boolean sameTree(Node<E> root1, Node<E> root2) {
        // Implement the body of this method
        if (root1 == null && root2 == null) return true;
        else if (root1 != null && root2 == null) return false;
        else if (root1 == null && root2 != null) return false;
        else {
            if (root1.data == root2.data && sameTree(root1.left, root2.left) && sameTree(root1.right, root2.right))
                return true;
            else
                return false;
        }
    }


    public boolean isBST() {
        return isBST(root);
    }

    // soulution #1
     /*
    // Returns true if the given root belongs to a BST
    public boolean isBST(Node<E> node) {
        // Implement the body of this method
        if (node == null) return true;
        else if (node.left != null && node.right != null)
        {
            int compareLeft = node.left.data.compareTo(node.data);
            int compareRight = node.right.data.compareTo(node.data);
            if (compareLeft < 0 && compareRight > 0) {
                return (isBST(node.left) && isBST(node.right));
            }
            else return false;
        }else if(node.left == null && node.right != null)
        {
            return isBST(node.right);
        }
        else if(node.left != null && node.right==null){
            return isBST(node.left);
        }
        return true;
    }

    */

    //Solution #2

    public boolean isBST(Node<E> node) {
        if (node == null) return true;
        if (node.left != null && node.right != null) {
            E min = minimum(node);
            E max = maxmum(node);
            int compareMin = min.compareTo(node.data);
            int compareMax = max.compareTo(node.data);
            if (compareMin > 0 || compareMax < 0) return false;

            else
                return (isBST(node.left) && isBST(node.right));
        }else if(node.left == null && node.right != null){
            return isBST(node.right);
        }else if(node.left != null && node.right == null){
            return isBST(node.left);
        }
        return true;
    }
}