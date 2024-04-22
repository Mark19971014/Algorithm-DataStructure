package Tree;

public class SymmetricTree_101 {
    public boolean isSymmetric(TreeNode root){
        if(root == null) return true;
        return compareSubTree(root,root);
    }

    private boolean compareSubTree(TreeNode leftRoot, TreeNode rightRoot) {
        // reach the leaf, base case
        if(leftRoot == null && rightRoot == null) return true;
        if((leftRoot != null && rightRoot == null) || (leftRoot == null && rightRoot != null) || (leftRoot.val != rightRoot.val)) return false;
        return compareSubTree(leftRoot.left,rightRoot.right) && compareSubTree(leftRoot.right,rightRoot.left);
    }

    public static void main(String[] args) {
        // Creating a symmetric tree
        //       1
        //     /   \
        //    2     2
        //   / \   / \
        //  3   4 4   3
        TreeNode symmetricRoot = new TreeNode(1);
        symmetricRoot.left = new TreeNode(2);
        symmetricRoot.right = new TreeNode(2);
        symmetricRoot.left.left = new TreeNode(3);
        symmetricRoot.left.right = new TreeNode(4);
        symmetricRoot.right.left = new TreeNode(4);
        symmetricRoot.right.right = new TreeNode(3);

        SymmetricTree_101 solution = new SymmetricTree_101();
        System.out.println("Is tree symmetric? " + solution.isSymmetric(symmetricRoot)); // Expected: true

        // Creating an asymmetric tree
        //       1
        //     /   \
        //    2     3
        TreeNode asymmetricRoot = new TreeNode(1);
        asymmetricRoot.left = new TreeNode(2);
        asymmetricRoot.right = new TreeNode(3);

        System.out.println("Is tree symmetric? " + solution.isSymmetric(asymmetricRoot)); // Expected: false
    }
}
