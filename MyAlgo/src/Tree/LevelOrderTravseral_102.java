package Tree;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTravseral_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size;i++){
                TreeNode cur = queue.poll();
                level.add(cur.val);
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
            }

            res.add(level);
        }
        return res;
    }

    public static void main(String[] args) {
        LevelOrderTravseral_102 test = new LevelOrderTravseral_102();
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