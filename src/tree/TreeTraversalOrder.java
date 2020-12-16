package tree;

/**
 * Created by gonyezsolt on 12/02/2017.
 */
public class TreeTraversalOrder {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);

        preorder(tree);
        System.out.print('\n');

        inorder(tree);
        System.out.print('\n');

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
}
