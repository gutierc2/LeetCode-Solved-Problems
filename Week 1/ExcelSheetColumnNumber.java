class Solution {
    
    // For this problem I had to think about how our number
    // systems work. For example with binary, if we have 1001,
    // we have 1 2^0 and 1 2^3 and we add those together to get 9.
    // This problem is essentially asking us:
    // "convert this from base 26 to base 10"
    public int titleToNumber(String s) {
        int runningTotal = 0;
        
        for(int i = s.length()-1; i >= 0; i--)
        {
            int power = s.length() - 1 - i;
            runningTotal += charValue(s.charAt(i)) * ((int)Math.pow(26,power));
        }
        
        return runningTotal;
    }
    
    private int charValue(char c)
    {
        return ((int) c) - 64;
    }
}