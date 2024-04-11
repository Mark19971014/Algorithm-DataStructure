package Tree;

public class LCA_263 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if the root is null, or root is either p or q, then root is LCA
        if (root == null || root == p || root == q) {
            return root;
        }

        // Search left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If searching the left and right subtrees returns non-null, root is LCA
        if (left != null && right != null) {
            return root;
        }
        // Else, if one of them is non-null, return the non-null value
        return left != null ? left : right;
    }

    public static void main(String[] args) {

            // Construct the binary tree from the example
            TreeNode root = new TreeNode(3);
            root.left = new TreeNode(5);
            root.right = new TreeNode(1);
            root.left.left = new TreeNode(6);
            root.left.right = new TreeNode(2);
            root.right.left = new TreeNode(0);
            root.right.right = new TreeNode(8);
            root.left.right.left = new TreeNode(7);
            root.left.right.right = new TreeNode(4);

            // Find the LCA of nodes 5 and 1
            TreeNode p =  root.left.right.right; // Node with value 5
            TreeNode q = root.left.right.left; // Node with value 1

            LCA_263 solution = new LCA_263();
            TreeNode lca = solution.lowestCommonAncestor(root, p, q);

            System.out.println("The LCA of nodes 7 and 4 is: " + (lca != null ? lca.val : "null"));
        }
    }

