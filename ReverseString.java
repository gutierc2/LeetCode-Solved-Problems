class Solution {
    
    // We go through half the string and swap the 
    // character with the corresponding char at the
    // other end of the string
    public void reverseString(char[] s) {
        for (int i = 0;  i < s.length/2; i++)
        {
            char c = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = c;
        }
    }
}