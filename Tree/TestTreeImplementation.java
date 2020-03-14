package Tree;


public class TestTreeImplementation {
    public static void main(String[] args) {

        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<Integer>();

        Position<Integer> root = tree.addRoot(5);
        Position<Integer> leftChild1 = tree.addLeft(root,3);
        Position<Integer> rightChild1 = tree.addRight(root, 6);

        tree.addLeft(leftChild1, 2);
        tree.addRight(leftChild1, 4);

        tree.positionsPreorder().forEach(node -> {
            try {
                System.out.println(node.getElement());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });

        tree.positionsInorder().forEach(node -> {
            try {
                System.out.println(node.getElement());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });

        tree.positionsPostorder().forEach(node -> {
            try {
                System.out.println(node.getElement());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });

    }
}
