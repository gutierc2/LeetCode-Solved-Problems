class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int contentChildren = 0;
        
        Arrays.sort(g);
        Arrays.sort(s);
        
        int endIndex = s.length-1;
        
        for (int i = g.length-1; i >= 0 && endIndex >= 0; i--)
        {
            if (s[endIndex] >= g[i])
            {
                endIndex--;
                contentChildren++;
            }
        }
        
        return contentChildren;
        
    }
    
    
}