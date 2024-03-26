package Tree;

public class sameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null){
            return false;
        }


        if(p.val != q.val){
            //check left
            return false;

        }
        boolean isLeftSame =  isSameTree(p.left,q.left);
        boolean isRightSame = isSameTree(p.right,q.left);

        return isLeftSame && isRightSame;
    }
    public static void main(String[]args ){
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);


        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);



        sameTree test = new sameTree();
        System.out.println(test.isSameTree(p,q));

    }
}
