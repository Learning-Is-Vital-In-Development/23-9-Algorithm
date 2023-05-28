package week6;

public class lc_101_harilsong {
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            // root 가 null 이면 대칭
            if (root == null) {
                return true;
            }
            return isSymmetric(root.left, root.right);
        }

        public boolean isSymmetric(TreeNode left, TreeNode right) {
            if (left == null && right == null) return true;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }
    }
}
