class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> partition = new ArrayList<Integer>();
        
        int[] li = lastIndex(S);
        
        int start = 0;
        int end = 0;
        
        for(int i = 0; i < S.length(); i++)
        {
            if (li[S.charAt(i) - 'a'] > end)
                end = li[S.charAt(i) - 'a'];
            
            if (i == end)
            {
                partition.add(end-start+1);
                start = end+1;
            }
        }
        
        return partition;
    }
    
    private int[] lastIndex(String s)
    {
        int[] arr = new int[26];
        
        for(int i = 0; i < s.length(); i++)
        {
            arr[s.charAt(i) - 'a'] = i;
        }
        
        return arr;
    }
}