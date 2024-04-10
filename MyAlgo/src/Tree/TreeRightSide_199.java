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

            // we must fix the size of the queue because after entering the for loop, the size of queue changed .
            int levelLength = q.size();
            for (int i = 0; i < levelLength; i++) {
                TreeNode currentNode = q.poll();
                if (currentNode != null) {
                    right = currentNode; // keep track the right node until reach the end of queue,(queue.poll == null)
                    if (currentNode.left != null) {
                        q.offer(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        q.offer(currentNode.right);
                    }
                }
            }
            assert right != null;
            res.add(right.val); // Add the value of the rightmost node after processing the level
        }
        return res;
    }
}


