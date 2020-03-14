package binaryTree;

import java.util.ArrayList;

public interface TreeNode {
    public ArrayList<? extends TreeNode> getChildren();
    public  TreeNode getParent();
    public  String toString();
}
