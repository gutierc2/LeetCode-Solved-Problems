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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> output1 = new ArrayList<Integer>();
        ArrayList<Integer> output2 = new ArrayList<Integer>();
        
        postorder(output1, root1);
        postorder(output2, root2);

        return output1.equals(output2);
    }
    
    private void postorder(ArrayList<Integer> output, TreeNode root)
    {
        if (root.left != null)
            postorder(output, root.left);
        
        if (root.right != null)
            postorder(output, root.right);
        
        if (root.left == null && root.right == null)
            output.add(root.val);
    }
}