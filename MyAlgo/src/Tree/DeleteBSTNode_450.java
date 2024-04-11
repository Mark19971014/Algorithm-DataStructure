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
                deleteNode(root.right,root.val);

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
