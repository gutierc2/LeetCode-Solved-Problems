class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();
        
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            
            if (sMap.containsKey(c))
            {
                sMap.put(c, sMap.get(c)+1);
            }
            else
            {
                sMap.put(c, 1);
            }
        }
        
        for (int i = 0; i < t.length(); i++)
        {
            char c = t.charAt(i);
            
            if (tMap.containsKey(c))
            {
                tMap.put(c, tMap.get(c)+1);
            }
            else
            {
                tMap.put(c, 1);
            }
        }
        
        for (Map.Entry<Character, Integer> entry : tMap.entrySet())
        {
            char c = entry.getKey();
            if (!sMap.containsKey(c) || entry.getValue() != sMap.get(c))
            {
                return c;
            }
        }
        
        return 'c';
    }
}