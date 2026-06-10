package letcode2026;

public class MaximumDepthOfBinaryTree {

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

      public static int maxDepth(TreeNode root){
          if (root == null) return 0;
          int levelleft = 0;
          int levelright = 0;
          levelleft = maxDepth(root.left) +1;
          levelright = maxDepth(root.right) + 1;
          return Math.max(levelright, levelleft);
      }

      public static void main(String[] args){

      }

}

