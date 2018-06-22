package traverse;

public class TreeTraversalOrder {

    public static void main(String[] args) {

        TreeNode tree = buildTree();

        System.out.println("***  Preorder *** ");
        preorder(tree);
        System.out.print('\n');

        System.out.println("***  Inorder *** ");
        inorder(tree);
        System.out.print('\n');

        System.out.println("***  Postorder *** ");
        postorder(tree);
        System.out.print('\n');
    }

    static void preorder(TreeNode tree) {
        if (tree != null) {
            System.out.print(tree.key);
            preorder(tree.left);
            preorder(tree.right);
        }
    }

    static void inorder(TreeNode tree) {
        if (tree != null) {
            inorder(tree.left);
            System.out.print(tree.key);
            inorder(tree.right);
        }
    }

    static void postorder(TreeNode tree) {
        if (tree != null) {
            postorder(tree.left);
            postorder(tree.right);
            System.out.print(tree.key);
        }
    }

    static TreeNode buildTree() {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        return tree;
    }
}

class TreeNode {
    int key;
    TreeNode left, right;

    public TreeNode(int item) {
        key = item;
        left = right = null;
    }
}