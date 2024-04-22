package Tree;

public class SumRootToLeaf_129 {
    public int sumNumbers(TreeNode root) {

        return dfs(root,0);
    }

    private int dfs(TreeNode root, int pathSum) {
        if(root == null) return 0;
        pathSum = pathSum * 10 + root.val;
        if(root.left == null && root.right == null) return pathSum;

        return dfs(root.left,pathSum) + dfs(root.right,pathSum);
    }

    public static void main(String[] args) {
        SumRootToLeaf_129 test = new SumRootToLeaf_129();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(test.sumNumbers(root));
    }
}
