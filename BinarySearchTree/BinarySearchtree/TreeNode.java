package BinarySearchTree.BinarySearchtree;

public class TreeNode {
    private Integer data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(Integer data) { this.data = data; }

    public static TreeNode addSorted(int[] data, int start, int end){
        if(end >= start){
            int mid = (start+end)/2;
            TreeNode newNode = new TreeNode(data[mid]);
            newNode.leftChild = addSorted(data, start, mid-1);

        }
    }
}
