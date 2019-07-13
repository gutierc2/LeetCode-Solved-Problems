class Solution {
    // Sorting solution so much slower than hashmap solution
    public List<Integer> findAnagrams(String s, String p) {
        
        
        List<Integer> output = new ArrayList<Integer>();
        char[] pSorted = p.toCharArray();
        Arrays.sort(pSorted);
        
        for (int i = 0; i < s.length() && i+p.length() <= s.length(); i++)
        {
            char[] subSorted = s.substring(i, i+p.length()).toCharArray();
            Arrays.sort(subSorted);
            
            if (Arrays.equals(pSorted, subSorted))
                output.add(i);
        }
        
        return output;
        
        /*
        List<Integer> output = new ArrayList<Integer>();
        HashMap<Character, Integer> window = new HashMap<Character, Integer>();
        HashMap<Character, Integer> pMap = new HashMap<Character, Integer>();
        
        for (int i = 0; i < p.length(); i++)
        {
            if (pMap.containsKey(p.charAt(i)))
            {
                pMap.put(p.charAt(i), (pMap.get(p.charAt(i))+1));
            }
            else
            {
                pMap.put(p.charAt(i), 1);
            }
        }
        
        for (int i = 0; i < p.length() && i < s.length(); i++)
        {
            if (window.containsKey(s.charAt(i)))
            {
                window.put(s.charAt(i), (window.get(s.charAt(i))+1));
            }
            else
            {
                window.put(s.charAt(i), 1);
            }
        }
        
        for (int i = 0; i < s.length() && (i+p.length()-1) < s.length(); i++)
        {
            if (window.equals(pMap))
                output.add(i);
            
            if (window.get(s.charAt(i)) > 1)
            {
                window.put(s.charAt(i), (window.get(s.charAt(i))-1));
            }
            else
            {
                window.remove(s.charAt(i));
            }
            
            int index = i+p.length();
            if (index < s.length())
            {
                if (window.containsKey(s.charAt(index)))
                {
                    window.put(s.charAt(index), (window.get(s.charAt(index))+1));
                }
                else
                {
                    window.put(s.charAt(index), 1);
                }
            }
        }
        
        return output;
        */
    }
}