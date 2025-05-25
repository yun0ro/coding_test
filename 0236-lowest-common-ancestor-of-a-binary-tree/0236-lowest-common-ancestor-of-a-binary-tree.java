/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 부모를 가리키는 포인터는 없다.
        // 부모 맵 구성 -> key = 자식, value = 부모
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root);
        parent.put(root, null);

        // p, q를 모두 찾을 때까지 탐색
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode cur = dq.poll();
            if (cur.left != null)  { 
                parent.put(cur.left,  cur); 
                dq.add(cur.left); 
            }
            if (cur.right != null) { 
                parent.put(cur.right, cur); 
                dq.add(cur.right); 
            }
        }

        // p의 모든 조상을 집합에 저장
        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            // p의 값을 부모로 변경하여 반영
            p = parent.get(p);
        }

        // q를 따라 올라오며 첫 교집합 노드 반환
        while (!ancestors.contains(q)) {
            // q와 p의 조상이 겹치는 부분이 나올 때까지 ㄱㄱ
            q = parent.get(q);
        }
        return q;
    }
}

// 6ms 걸리는 답 (내껀 12ms)
// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         if(root == null || root == p || root == q) return root;
//         TreeNode left = lowestCommonAncestor(root.left,p,q);
//         TreeNode right = lowestCommonAncestor(root.right,p,q);
//         if(left != null && right != null) return root;
//         return left != null ? left : right; 
//     }
// }