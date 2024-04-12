package Tree;

public class DeleteBSTNode_450 {
        public TreeNode deleteNode(TreeNode root, int key){
            if (root == null) return null;

            if (key < root.val){
                // why we need to assign ?
                root.left = deleteNode(root.left,key);
            } else if (key > root.val) {
                root.right = deleteNode(root.right,key);
            }
            else {
                // Node has either one or no child
                if(root.left == null){
                    return  root.right;
                } else if (root.right == null) {
                    return  root.left;
                }
                // node has two child
                // replace the root with the smallest node on the right sub tree
                root.val = minOnRight (root.right);
                // delete the left most on the right subtree, set it reference as null, finally reach line 15 in the recursion
                // the assignment is necessary because I need to update the reference of the node,
               /*By assigning this result to root.right, you're effectively saying,
               "The right child of this node is now whatever the result of the delete operation was,"
                which could be null (if a leaf was deleted) or a subtree (if a node with children was deleted).*/
                root.right =  deleteNode(root.right,root.val);

            }
            return  root;
        }

    private int minOnRight(TreeNode root) {
        int min = root.val;
        // reach the most left
        while (root.left != null) {
            min = root.left.val;
            root = root.left;
        }
        return  min;
        }
}
