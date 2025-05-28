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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 둘 다 비어 있으면 같음
        if (p == null && q == null) return true;

        // 한쪽만 비어 있으면 다름
        if (p == null || q == null) return false;

        // 현재 노드 값이 다르면 다름
        if (p.val != q.val) return false;

        // 좌·우 서브트리를 각각 비교
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}