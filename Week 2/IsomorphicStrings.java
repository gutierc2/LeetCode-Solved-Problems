class Solution {
    // Instead of using HashMap's "containsValue" method, which runs in
    // O(n) time (and thus turning this problem into O(n^2) time complexity),
    // I created a set to contain all the values stored in the map, that way I can
    // simply check the set to see if a value already has a key  associated
    // with it.
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> iso = new HashMap<Character, Character>();
        HashSet<Character> vals = new HashSet<Character>();
        
        for(int i = 0; i < s.length(); i++)
        {
            if(!iso.containsKey(s.charAt(i)))
            {
                if(!vals.contains(t.charAt(i)))
                {
                    iso.put(s.charAt(i), t.charAt(i));
                    vals.add(t.charAt(i));
                }
                else
                {
                    return false;
                }
            }
            else if (iso.get(s.charAt(i)) != t.charAt(i))
                return false;
        }
        
        return true;
    }
}