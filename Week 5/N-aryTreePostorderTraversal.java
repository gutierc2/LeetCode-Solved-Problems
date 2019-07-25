/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> postorder(Node root) {
        
        List<Integer> output = new ArrayList<Integer>();
        
        if (root == null)
            return output;
        
        postorder(output, root);
        
        return output;
    }
    
    private void postorder(List<Integer> output, Node root)
    {
        for(int i = 0; i < root.children.size(); i++)
        {
            postorder(output, root.children.get(i));
        }
        
        output.add(root.val);
    }
}