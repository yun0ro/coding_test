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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // 결과를 저장할 중첩list
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, targetSum, 0, new ArrayList<>(), result);
        return result;
    }

    private void dfs(TreeNode node, int targetSum,
                     int sum, List<Integer> path,
                     List<List<Integer>> result) {

        if (node == null) return;

        // 현재 노드 path add, 경로 합에 value +
        sum += node.val;
        path.add(node.val);

        // leaf node인지 확인
        if (node.left == null && node.right == null) {
            // leaf node이고, 경로합이 동일하다면 result에 add
            if (sum == targetSum) {
                result.add(new ArrayList<>(path));
            }
        } else {
            // 자식 노드 DFS
            dfs(node.left,  targetSum, sum, path, result);
            dfs(node.right, targetSum, sum, path, result);
        }

        // 백트래킹
        // 현재까지 왔던 path를 하나 삭제한다. 
        // if문 안에 들어갔던 leafnode까지 도달한 path이므로.
        path.remove(path.size() - 1);
    }
}