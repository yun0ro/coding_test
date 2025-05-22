/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            // leaf node의 왼쪽 or 오른쪽 도달 = depth가 0
            return 0;
        }
        int leftdepth = maxDepth(root.left);
        int rightdepth = maxDepth(root.right);
        return Math.max(leftdepth, rightdepth) + 1;
    }
}