package Tree;

import java.util.*;

public class TreeRightSide_199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        TreeNode right = null;
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curNode = null;
            // traverse each level
            for(int i = 0; i < q.size();i++){
                curNode = q.pollFirst();
                if (curNode != null){
                    right = curNode;
                    q.offer(curNode.left);
                    q.offer(curNode.right);
                }
            }
            res.add(right.val);
        }
        return res;
    }
}
