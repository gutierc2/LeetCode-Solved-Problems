class Solution {
    // Since there is no actual multiset in java standard library,
    // we instead use a hashmap and update the values that tell us
    // how many of that element we have.
    
    // There's a lot of if statements and for loops in this solution
    // so I added brackets all around for clarity.
    public List<Integer> findAnagrams(String s, String p) {
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
    }
}