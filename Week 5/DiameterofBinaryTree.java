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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        
        int diameter = height(root.left) + height(root.right);
        int ldiameter = diameterOfBinaryTree(root.left);
        int rdiameter = diameterOfBinaryTree(root.right);
        
        if (diameter >= ldiameter && diameter >= rdiameter)
            return diameter;
        else if (ldiameter >= diameter && ldiameter >= rdiameter)
            return ldiameter;
        else
            return rdiameter;
    }
    
    private int height(TreeNode root)
    {
        if (root == null)
            return 0;
        
        int lsubtreeheight = height(root.left) + 1;
        int rsubtreeheight = height(root.right) + 1;
        
        return (lsubtreeheight > rsubtreeheight) ? lsubtreeheight : rsubtreeheight;
            
    }
}