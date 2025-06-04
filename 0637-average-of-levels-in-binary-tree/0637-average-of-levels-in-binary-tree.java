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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> nodes = new ArrayDeque<>();
        List<Double> result = new ArrayList<>();

        nodes.offer(root);

        while(!nodes.isEmpty()){
            int count = 0;
            double sum = 0;
            int q_size = nodes.size();

            for(int i = 0; i < q_size; i++){
                TreeNode node = nodes.poll();

                if(node.left != null) nodes.offer(node.left);
                if(node.right != null) nodes.offer(node.right);

                // 전체 합계
                sum += node.val;
                count++;
            }
            // 같은 level의 val 평균
            result.add((double)sum / count);
        }
        return result;
    }
}