package Tree;

public class SameTree_100 {
    public boolean isSame(TreeNode p,TreeNode q){
        if (p == null && q == null) return true;
        if ((p != null && q == null) || (p == null && q != null) || (p.val != q.val)) return false;

        return isSame(p.left,q.left) && isSame(p.right,q.right);
    }
}
