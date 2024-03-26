package Tree;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTravseral {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.offer(root);
        // while queue is not empty we can expand the treeNode in the queue.
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            while (size != 0) {
                TreeNode cur = queue.poll();
                int val = cur.val;
                level.add(val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                size--;
            }
            result.add(level);
        }
        return result;
    }

    public static void main(String[] args) {
        LevelOrderTravseral test = new LevelOrderTravseral();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = null;
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        root.right.left = null;
        root.right.right.left = new TreeNode(9);
        System.out.println(test.levelOrder(root));
    }
}
     /*         1
        2          3
            5         4
                    9
*/