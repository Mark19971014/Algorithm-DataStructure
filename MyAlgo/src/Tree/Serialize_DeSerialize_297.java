package Tree;


import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/*Serialize :build a string from a tree
* DeSerialize: build a tree from string */
public class Serialize_DeSerialize_297 {

    public String serialize(TreeNode root){
        if(root == null) return "";
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode curNode = queue.poll();
            if(curNode == null){
                res.append("#,");
                continue;
            }
            res.append(curNode.val).append(",");
            queue.add(curNode.left);
            queue.add(curNode.right);
        }
        // remove the last coma;
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }


    public TreeNode deserialize(String data){
        if(data.isEmpty()) return null;
        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while(i < nodes.length && !queue.isEmpty()){
            TreeNode parent = queue.poll();
            // current "string" is not null
            if(!Objects.equals(nodes[i], "#")){
                TreeNode left = new TreeNode(Integer.parseInt(nodes[i]));
                parent.left = left;
                queue.add(left);
            }
            i++;

            if(!Objects.equals(nodes[i], "#")){
                TreeNode right = new TreeNode(Integer.parseInt(nodes[i]));
                parent.right = right;
                queue.add(right);
            }
            i++;
        }
        return root;
    }
}
