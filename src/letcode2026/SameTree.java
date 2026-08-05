package letcode2026;

import java.util.ArrayList;
import java.util.List;

public class SameTree {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if(p == null || q == null || p.val != q.val){
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args){
        TreeNode p = new TreeNode(1, new TreeNode(2),null);
        TreeNode q = new TreeNode(1, null,new TreeNode(2));
        System.out.println(isSameTree(p,q));
    }
}
