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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        inorder(root1, list1);
        inorder(root2, list2);

        // 병합
        List<Integer> result = new ArrayList<>(list1.size() + list2.size());
        int i = 0, j = 0;
        // list size만큼 중위순회한 node들을 출력
        while (i < list1.size() || j < list2.size()) {
            // list2가 끝에 도달했을 경우
            if (j == list2.size() 
                // list1이 남아있고, list2보다 작을 경우
                || (i < list1.size() && list1.get(i) <= list2.get(j))
                ) {
                result.add(list1.get(i++));
            }
            else 
                result.add(list2.get(j++));
        }
        return result;
    }

    // 중위 순회
    public void inorder(TreeNode root, List<Integer> list){
        if(root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}