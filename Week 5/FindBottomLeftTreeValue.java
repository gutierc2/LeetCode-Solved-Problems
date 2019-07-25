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
    public int findBottomLeftValue(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode current = root;
        
        while(!queue.isEmpty())
        {
            current = queue.remove();
            if (current.right != null)
                queue.add(current.right);
            if (current.left != null)
                queue.add(current.left);
        }
        
        return current.val;
    }

}