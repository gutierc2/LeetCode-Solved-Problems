class Solution {
    
    // I used hashset for this problem since 'add' and 'contains' operations
    // are constant time. "charAt" is also constant time. This allows us to 
    // solve the problem in linear time.
    public int numJewelsInStones(String J, String S) {
        
        HashSet<Character> jewels = new HashSet<Character>(J.length(), 1.1f);
        
        for (int i = 0; i < J.length(); i++)
        {
            jewels.add(J.charAt(i));
        }
        
        int counter = 0;
        
        for (int i = 0; i < S.length(); i++)
        {
            if (jewels.contains(S.charAt(i)))
                counter++;
        }
        
        return counter;
    }
}