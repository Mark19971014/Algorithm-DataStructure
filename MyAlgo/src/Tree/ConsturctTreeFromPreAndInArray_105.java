package Tree;

import java.util.HashMap;
import java.util.Map;

public class ConsturctTreeFromPreAndInArray_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preleft = 0;
        int preright = preorder.length - 1;
        int inleft = 0;
        int inright = inorder.length;
        //assume there is no repetitive element
        Map<Integer, Integer> map = new HashMap<>(preorder.length);
        for (int i = 0; i < preorder.length; i++) {
            map.put(preorder[i], i);
        }

        return buildTree(preorder, preleft, preright, inleft, inright, map);
    }

    public TreeNode buildTree(int[] preorder, int preleft, int preright, int inleft, int inright, Map<Integer, Integer> map) {
        if (preleft > preright || inleft > inright) {
            return null;
        }

        int rootVal = preorder[preleft];
        TreeNode root = new TreeNode(rootVal);
        int pIndex = map.get(root);

        root.left = buildTree(preorder, preleft + 1, pIndex - inleft + preleft, inleft, pIndex - 1, map);
        root.right = buildTree(preorder, pIndex - inleft + preleft + 1, preright, pIndex + 1, inright, map);
        return root;
    }

}

