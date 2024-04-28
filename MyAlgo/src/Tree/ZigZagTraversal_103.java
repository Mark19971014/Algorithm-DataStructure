package Tree;

import java.util.*;

public class ZigZagTraversal_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        deque.add(root);
        int levelType = 0;
        boolean leftToRight = true;
        while(!deque.isEmpty()){
            int size = deque.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode cur;
                // even level 0, 2, 4: left->right
                if(leftToRight){
                    cur = deque.pollFirst();
                    if(cur.left != null){
                        deque.offerLast(cur.left);
                    }
                    if(cur.right != null){
                        deque.offerLast(cur.right);
                    }
                }else{
                    // odd level 1,3,5 : right->left
                    cur = deque.pollLast();
                    if(cur.right != null){
                        deque.offerFirst(cur.right);
                    }
                    if(cur.left != null){
                        deque.offerFirst(cur.left);
                    }
                }

                level.add(cur.val);
            }
            // we flip the direction once current level done
            leftToRight = !leftToRight;
            result.add(level);
        }

        return result;
    }

    public static void main(String[] args) {
        ZigZagTraversal_103 test = new ZigZagTraversal_103();
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        TreeNode node20 = new TreeNode(20, node15, node7);
        TreeNode node9 = new TreeNode(9);
        TreeNode root = new TreeNode(3, node9, node20);
        System.out.println(test.zigzagLevelOrder(root));

    }
}
