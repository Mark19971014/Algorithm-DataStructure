package Tree;
// Given the root of a binary tree, determine if it is a valid binary search tree (BST).
public class ValidBST_98 {
    public boolean isValidBST(TreeNode root){


        return boundary(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean boundary(TreeNode root, long left, long right) {

        if (root == null) return  true;

        if(root.val >= right || root.val <= left){
            return false;
        }
                    // left child must less than the root, right child must greater than root
        return (boundary(root.left,left,root.val) && boundary(root.right, root.val,right));
    }

    public static void main(String[] args) {
        ValidBST_98 solution = new ValidBST_98();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(4); // This should make the tree invalid
        root.right.right = new TreeNode(8);

        boolean isValid = solution.isValidBST(root);
        System.out.println("Is the tree a valid BST? " + isValid);
    }
}
