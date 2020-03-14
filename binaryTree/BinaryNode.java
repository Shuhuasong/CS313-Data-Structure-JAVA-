package binaryTree;

import javax.swing.*;
import java.util.ArrayList;

/*public class BinaryNode<T> implements TreeNode {

    T data;
    BinaryNode<T> left, right, parent;

    public BinaryNode() { parent = left = right = null; }

    public BinaryNode(BinaryNode<T> p, BinaryNode<T> l, BinaryNode<T> r, T d)
    {
        parent = p;
        left = l;
        right = r;
        data = d;
    }

    @Override
    public ArrayList<? extends TreeNode> getChildren() {
        ArrayList<BinaryNode<T>> answer =  new ArrayList<>();
        if(left != null) answer.add(left);
        if(right !=null) answer.add(right);
        return answer;
    }

    @Override
    public TreeNode getParent() { return parent; }

    public void setParent(BinaryNode<T> node) { parent = node; }

    @Override
    public String toString() { return data.toString(); }

    public void setLeft(BinaryNode<T> n) { left = n; }

    public void setRight(BinaryNode<T> n) { right = n; }

    public BinaryNode<T> getLeft() { return left; }

    public BinaryNode<T> getRight() { return right; }

    public void removeChild(BinaryNode<T> n) {
        if(getLeft() == n)
            setLeft(null);
        if(getRight()==n)
            setRight(null);
    }



    public T getData() { return data; }

    public void setData(T newData)  { data = newData; }
}

 */
