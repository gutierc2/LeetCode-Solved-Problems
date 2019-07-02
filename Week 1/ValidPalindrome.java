class Solution {
    // Not much to say about this problem
    // Linear time and space complexity
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        
        while(j > i)
        {
            if (!isAlphaNumeric(s.charAt(j)))
            {
                j--;
                continue;
            }
            
            if(!isAlphaNumeric(s.charAt(i)))
            {
                i++;
                continue;
            }
            
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                return false;
            
            i++;
            j--;
        }
        
        return true;
    }
    
    private boolean isAlphaNumeric(char c)
    {
        return Character.isDigit(c) || Character.isLetter(c);
    }
}