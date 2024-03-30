package Tree;

import java.util.*;

public class TreeRightSide_199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        TreeNode right = null;
        if (root == null) return res;
        q.offer(root);
        while (!q.isEmpty()) {
            int levelLength = q.size();
            for (int i = 0; i < levelLength; i++) {
                TreeNode currentNode = q.poll();
                if (currentNode != null) {
                    right = currentNode; // This ensures that the rightmost node of the current level is stored
                    if (currentNode.left != null) {
                        q.offer(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        q.offer(currentNode.right);
                    }
                }
            }
            res.add(right.val); // Add the value of the rightmost node after processing the level
        }
        return res;
    }
}
