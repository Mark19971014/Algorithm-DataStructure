package Tree;
/*Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.*/
public class FlattenBinaryTreeToLinkedList_114 {
    public void flatten(TreeNode root){
        dfs(root);
    }

    public TreeNode dfs(TreeNode root) {
        if (root == null) return null;

        // the end of left subtree, Flatten left subtree and return the tail of the left subtree
        TreeNode leftTail = dfs(root.left);

        // the end of right subtree
        TreeNode rightTail = dfs(root.right);
        if (leftTail != null) {

            // put left subtree in between the current root node and its right subtree
            /*
             *       1    ->     1
             *     2   3             2(left tail -> point to the root 1's right node)
             *                           3
             * */
            leftTail.right = root.right;

            // after insertion, original root right pointer, point to the left(the head of left sub tree)
            root.right = root.left;
            // the current left node always is null;
            root.left = null;
        }

        if (rightTail != null) {
            return rightTail;
        } else if (leftTail != null) {
            return leftTail;
        } else {
            return root;
        }
    }
}
