package Tree;

import java.util.HashMap;
import java.util.Map;


public class ConstructTreeFromPostAndInArray_106 {
    int rootIdx;
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) {
            return null;
        }
        rootIdx = postorder.length - 1;
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        return buildTree(postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] postorder, int left, int right) {
        if (left > right) {
            return null;
        }

        int rootval = postorder[rootIdx--];
        TreeNode root = new TreeNode(rootval);
        int pivotIdx = map.get(rootval);

        root.right = buildTree(postorder, pivotIdx + 1, right);
        root.left = buildTree(postorder, left, pivotIdx - 1);

        return root;

    }
    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        int[] postorder = {9, 15, 7, 20, 3};
        int[] inorder = {9, 3, 15,20, 7};
        ConstructTreeFromPostAndInArray_106 treeConstructor = new ConstructTreeFromPostAndInArray_106();
        TreeNode root = treeConstructor.buildTree(inorder, postorder);
        // Print the constructed tree for verification
        printTree(root);

    }
}

