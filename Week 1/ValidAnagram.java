class Solution {
    // First solution I tried was the bottom  one
    
    // Tried the top commented out solution after
    // it was definitely faster, but did not save space
    public boolean isAnagram(String s, String t) {
        
        if (s.length() != t.length())
            return false;
        
        /*
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        
        //organize(sChars);
        //organize(tChars);
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        
        //System.out.println(sChars);
        //System.out.println(tChars);
        
        return Arrays.equals(sChars, tChars);
        
        //return sChars.equals(tChars);
        
        */
        
        
        HashMap<Character, Integer> sSet = new HashMap<Character, Integer>(s.length(), 1.1f);
        HashMap<Character, Integer> tSet = new HashMap<Character, Integer>(s.length(), 1.1f);
        
        for (int i = 0; i < s.length(); i++)
        {
            if(!sSet.containsKey(s.charAt(i)))
            {
                sSet.put(s.charAt(i), 1);
            }
            else
            {
                sSet.put(s.charAt(i), (sSet.get(s.charAt(i))+1));
            }
            
            if(!tSet.containsKey(t.charAt(i)))
            {
                tSet.put(t.charAt(i), 1);
            }
            else
            {
                tSet.put(t.charAt(i), (tSet.get(t.charAt(i))+1));
            }
        }
        
        return sSet.equals(tSet);
        
    }
    
    private void organize(char[] c)
    {
        for (int i = 0; i < c.length; i++)
        {
            for (int j = i+1; j < c.length; j++)
            {
                if (c[i] == c[j])
                {
                    swap(c,i+1,j);
                    i++;
                }
            }
        }
    }
    
    private void swap(char[] nums, int first, int second)
    {
        char i = nums[first];
        nums[first] = nums[second];
        nums[second] = i;
    }
}