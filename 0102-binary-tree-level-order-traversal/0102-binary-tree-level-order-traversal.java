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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // return값 list 선언
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        // node 저장 queue
        Queue<TreeNode> nodes = new ArrayDeque<>();
        nodes.offer(root);

        while(!nodes.isEmpty()){
            int q_size = nodes.size();
            // queue 사이즈만큼 선언
            // queue에는 같은 depth의 node들만 저장되어있음
            List<Integer> nodeVal = new ArrayList<>(q_size);

            for(int i=0; i < q_size; i++){
                // queue의 맨 앞에서 꺼내온다.
                TreeNode node = nodes.poll();
                
                // child node를 queue에 삽입
                if(node.left != null) nodes.offer(node.left);
                if(node.right != null) nodes.offer(node.right);

                // 같은 depth인 node들을 list에 삽입
                nodeVal.add(node.val);
            }
            // 같은 depth에 node list를 추가
            result.add(nodeVal);
        }
        return result;
    }
}