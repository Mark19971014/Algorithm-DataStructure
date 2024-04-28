package Tree;

public class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode() {
    }

    ;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode( int val,TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
        this.val = val;
    }
}
