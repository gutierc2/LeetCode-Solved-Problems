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
    public int longestUnivaluePath(TreeNode root) {
        if (root == null)
            return 0;
        
        int diameter = 0;
        
        if (root.right != null && root.val == root.right.val)
            diameter += univalueHeight(root.right) + 1;
        
        if (root.left != null && root.val == root.left.val)
            diameter += univalueHeight(root.left) + 1;
        
        int ldiameter = longestUnivaluePath(root.left);
        int rdiameter = longestUnivaluePath(root.right);
        
        if (diameter >= ldiameter && diameter >= rdiameter)
            return diameter;
        else if (ldiameter >= diameter && ldiameter >= rdiameter)
            return ldiameter;
        else
            return rdiameter;
    }
    
    private int univalueHeight(TreeNode root)
    {
        if (root == null)
            return 0;
        
        int lsubtreeheight = 0;
        int rsubtreeheight = 0;
        
        if (root.left != null)
            lsubtreeheight = (root.val == root.left.val) ? univalueHeight(root.left) + 1 : 0;
        
        if (root.right != null)
            rsubtreeheight = (root.val == root.right.val) ? univalueHeight(root.right) + 1 : 0;
        
        return (lsubtreeheight > rsubtreeheight) ? lsubtreeheight : rsubtreeheight;
            
    }
}