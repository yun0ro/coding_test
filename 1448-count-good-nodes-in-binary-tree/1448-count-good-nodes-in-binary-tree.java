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
class Pair{
    TreeNode node;
    int maxNum;
    Pair(TreeNode node, int val){
        this.node = node;
        this.maxNum = val;
    }
}
class Solution {
    public int goodNodes(TreeNode root) {
        if(root == null)
            return 0;
        int result = 0;

        Stack<Pair> values = new Stack<>();
        values.push(new Pair(root, root.val));

        while(!values.isEmpty()){
            Pair value = values.pop();
            TreeNode node = value.node;
            int val = value.maxNum;

            if(val <= node.val){
                result += 1;
                val = node.val;
            }
            if(node.left != null)
                values.push(new Pair(node.left, val));
            if(node.right != null)
                values.push(new Pair(node.right, val));
        }
        return result;
    }
}