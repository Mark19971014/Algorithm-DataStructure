package Tree;

public class PathSum_112 {
    public boolean hasPathSum(TreeNode root, int targetSum){
        if(root == null) return false;
        // leaf node is the base case
        if(root.left == null && root.right == null) return targetSum == root.val;

        targetSum -= root.val;

        return hasPathSum(root.left,targetSum) || hasPathSum(root.right, targetSum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left = new TreeNode(3);
        PathSum_112 test = new PathSum_112();
        System.out.println(test.hasPathSum(root,5));
    }
}
