package binaryTree;

import java.util.*;

public class BinaryTree<T> extends Tree {


    public BinaryTree() {
        super();
    }

    public void addRoot(T t) throws Exception {
        if (root() != null)
            throw new Exception("The tree is not empty");
        setRoot(new BinaryNode<T>(null, null, null, t));
        size++;
    }

    public void addLeft(BinaryNode<T> node, T t) throws Exception {
        if (node.getLeft() != null) {
            throw new Exception("Left child already exists");
        }
        node.setLeft(new BinaryNode<T>(node, null, null, t));
        size++;
    }

    public void addRight(BinaryNode<T> node, T t) throws Exception {
        if (node.getRight() != null) {
            throw new Exception("Right child alread exsits");
        }
        node.setRight(new BinaryNode<T>(node, null, null, t));
        size++;
    }

    //removes a leaf but promotes and removes a descendant otherwise
    // returns the parent of the node that is actually removed
    // @SuppressWarnings(unchecked)

    public BinaryNode<T> removeNode(BinaryNode<T> node) {
        if (isLeaf(node)) { //base case
            BinaryNode<T> parent = (BinaryNode<T>) node.getParent();
            if (parent == null) {
                setRoot(null);
            } else
                parent.removeChild(node);
            size--;
            return parent;
        }
        BinaryNode<T> lower = descendant(node);
        promote(lower, node);
        return removeNode(lower);
    }

    public void promote(BinaryNode<T> lower, BinaryNode<T> node) {
        node.data = lower.data;
    }

    public BinaryNode<T> descendant(BinaryNode<T> node) {
        if (node.left != null) return node.left;
        return node.right;
    }

    public ArrayList<BinaryNode<T>> inOrder() {
        ArrayList<BinaryNode<T>> answer = new ArrayList<BinaryNode<T>>();
        inOrder((BinaryNode<T>) root(), answer);
        return answer;
    }

    //inOrder Helper method
    //Time complexity : O(n)O(n). The time complexity is O(n)O(n) because the recursive function
    // is T(n) = 2 \cdot T(n/2)+1T(n)=2⋅T(n/2)+1.
    // Space complexity : The worst case space required is O(n)O(n), and in the average case
    // it's O(\log n)O(logn) where nn is number of nodes.
    private void inOrder(BinaryNode<T> node, ArrayList<BinaryNode<T>> order) {
        if (node == null)
            return;
        inOrder(node.getLeft(), order);
        order.add(node);
        inOrder(node.getRight(), order);
    }

    //root->left Child-> right Child
    public void printPreorder(BinaryNode<T> node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data + " ");
        printPreorder(node.getLeft());
        printPreorder(node.getRight());
    }

    public void printInorder(BinaryNode<T> node) {
        if (node == null) {
            return;
        }
        printPreorder(node.getLeft());
        System.out.println(node.data + " ");
        printPreorder(node.getRight());
    }

    public void printPostorder(BinaryNode<T> node) {
        if (node == null) {
            return;
        }
        printPreorder(node.getLeft());
        printPreorder(node.getRight());
        System.out.println(node.data + " ");
    }

    //breadth first search
    public void printBFS(BinaryNode<T> root) {
        Queue<BinaryNode<T>> queue = new LinkedList<BinaryNode<T>>();

        if (root() == null) return;
        queue.clear();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode<T> node = queue.remove();
            System.out.println(node.data + " ");
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

    }

    //Searching in a BST(breadth first search)
    /*public boolean doesNodeExistInBST(BinaryNode<T> root, T dataSearch){
        if(root==null) { return false; }
        else if(root.data == dataSearch){ return true; }
        else{
            if(dataSearch > root.data){
                return doesNodeExistInBST(root.getRight(), dataSearch)
            }else{
                return doesNodeExistInBST(root.getLeft(), dataSearch);
            }
        }
    } */

    //Height of Binary Tree
    int getBinaryTreeHeight(BinaryNode<T> node) {
        if (node == node) {
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

    /*
    Create empty stack
    Push root node onto stack
    While our stack is not empty: a. pop node from
    the stack and print it b. push right child of popped node to stack. c. push left child of
     popped node to stack

     Time complexity is O(n) since we push/pop each node of the tree, while space complexity
      is O(h), h being the height of the tree.
     */

    //  PreOrder Traversal
    public void preOrderTraversal(BinaryNode<T> root) {
        BinaryNode<T> node = root;
        Stack<BinaryNode> stack = new Stack<>();
        while (!stack.isEmpty()) {
            BinaryNode<T> curr = stack.pop();
            System.out.println(curr.data);
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }
    }

    //  InOrder Traversal using ArrayList
    public List<T> inOrderTraversal(BinaryNode<T> root) {
        List<T> inOrderList = new ArrayList<>();
        inOrderTraversalRecursive(root, inOrderList);
        return inOrderList;
    }

    public void inOrderTraversalRecursive(BinaryNode<T> root, List<T> list) {
        if (root == null) return;
        inOrderTraversalRecursive(root.left, list);
        list.add(root.data);
        inOrderTraversalRecursive(root.right, list);
    }

    // inOrderTraversal using Stack
    // Time complexity : O(n).  Space complexity : O(n)O(n).

    public List<T> inOrderStack(BinaryNode<T> root){
        List<T> res = new ArrayList<>();
        Stack<BinaryNode<T>> stack = new Stack<>();
        BinaryNode curr = root;
        while(curr!=null || !stack.isEmpty()) {
            while(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add((T) curr.data);
            curr = curr.right;
        }
        return res;
    }

    //PostOrder Traversal
    public List<T> postOrderTraversal(BinaryNode<T> root) {
        List<T> result = new ArrayList<T>();
        addToList(root, result);
        return result;
    }

    public void addToList(BinaryNode<T> node, List<T> list) {
        if (node == null) return;
        addToList(node.left, list);
        addToList(node.right, list);
        list.add(node.data);
    }


    //Binary Search Tree Iterator using Queue
    private Queue<BinaryNode<T>> queue;

    public void BSTIterator(BinaryNode<T> root) {
        this.queue = new LinkedList<>();
        this.inOrderTraversal(root);
    }


    public T next() {
        return (T) queue.poll();
    }

    public boolean hasNext(){
        return !queue.isEmpty();
    }
}
