class Solution {
    public int numSpecialEquivGroups(String[] A) {
        HashSet<String> groups = new HashSet<String>();
        
        for(String s : A)
        {
            groups.add(sortedWord(s));
        }
        
        return groups.size();
    }
    
    private String sortedWord(String s)
    {
        ArrayList<Character> oddLetters = new ArrayList<Character>();
        ArrayList<Character> evenLetters = new ArrayList<Character>();
        
        for (int i = 0; i < s.length(); i++)
        {
            if (i % 2 == 0)
                evenLetters.add(s.charAt(i));
            else
                oddLetters.add(s.charAt(i));
        }
        oddLetters.sort(Comparator.naturalOrder());
        evenLetters.sort(Comparator.naturalOrder());
        
        StringBuilder st = new StringBuilder();
        
        for (Character c : oddLetters)
        {
            st.append(c);
        }
        
        for (Character c : evenLetters)
        {
            st.append(c);
        }
        
        return st.toString();
    }
}