package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    List<Integer> result = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        // level order traversal the tree and add the last elements in the queue to the List
        if (root == null) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> res = new ArrayList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            while (size != 0) {
                TreeNode cur = queue.poll();
                assert cur != null;
                int val = cur.val;
                level.add(val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                //here I forget to decrement size!
                size--;
            }
            result.add(level);
        }

        for (List<Integer> integers : result) {
            res.add(integers.get(integers.size() - 1));
        }
        return res;
    }
        public static void main(String[]args ){
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);


            BinaryTreeRightSideView test = new BinaryTreeRightSideView();
            System.out.println(test.rightSideView(root));

        }
    }



//Solution from GPT
/*public List<Integer> rightSideView(TreeNode root) {
            if (root == null) {
                return result;
            }

            traverse(root, 0);

            return result;
        }

        private void traverse(TreeNode node, int level) {
            if (node == null) {
                return;
            }

            // Add the value of the current node if it's the rightmost node at the current level
            if (level == result.size()) {
                result.add(node.val);
            }

            // Traverse the right subtree first to get the rightmost nodes
            traverse(node.right, level + 1);
            traverse(node.left, level + 1);
        }
*/