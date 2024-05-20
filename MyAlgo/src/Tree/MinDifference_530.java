package Tree;

import java.util.ArrayList;
import java.util.List;

public class MinDifference_530 {
    public int getMinimumDifference(TreeNode root) {
        int diff = Integer.MAX_VALUE;
        List<Integer> nodeList = new ArrayList<>();
        inorderTraversal(root,nodeList);

        for(int i = 1; i < nodeList.size(); i++){
            diff = Math.min(nodeList.get(i) - nodeList.get(i - 1),diff);
        }

        return diff;
    }

    public void inorderTraversal(TreeNode root, List<Integer> nodeList){
        if(root == null) return;
        inorderTraversal(root.left,nodeList);
        nodeList.add(root.val);
        inorderTraversal(root.right,nodeList);

    }
}
