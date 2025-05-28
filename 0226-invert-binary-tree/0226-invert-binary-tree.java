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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;          

        // 교체
        // 바로 아래 자식만 교체해도 후손들까지 딸려옴
        TreeNode tmp = root.left;
        root.left  = root.right;
        root.right = tmp;

        // 서브트리 재귀 호출
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}