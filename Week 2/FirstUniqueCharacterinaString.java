class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
        
        for (int i = 0; i < s.length(); i++)
        {
            if (sMap.containsKey(s.charAt(i)))
            {
                sMap.put(s.charAt(i), sMap.get(s.charAt(i))+1);
            }
            else
            {
                sMap.put(s.charAt(i), 1);
            }
        }
        
        for (int i = 0; i < s.length(); i++)
        {
            if (sMap.get(s.charAt(i)) == 1)
                return i;
        }
        
        return -1;
    }
}