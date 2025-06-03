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
    public int maxLevelSum(TreeNode root) {
        if(root == null) return 0;

        Queue<TreeNode> nodes = new ArrayDeque<>();
        nodes.offer(root);

        // current levle, max level
        int curLevel = 1;
        int maxSum = root.val;
        int maxLevel = 1;

        while(!nodes.isEmpty()){
            int q_size = nodes.size();
            int curSum = 0;

            // 같은 level이 sum을 구함
            for(int i = 0; i < q_size; i++){
                TreeNode node = nodes.poll();
                curSum += node.val;

                if(node.left != null) nodes.offer(node.left);
                if(node.right != null) nodes.offer(node.right);
            }

            // level중 가장 큰 값 비교 및 갱신
            if(curSum > maxSum){
                maxSum = curSum;
                maxLevel = curLevel;
            }
            curLevel++;
        }
        return maxLevel;
    }
}