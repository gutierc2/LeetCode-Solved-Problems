class Solution {
    
    // The bottom solution seems to be much faster than the 
    // top or middle solution although I enjoyed trying all solutions
    // My first solution was solution 1 (slowest), then soluion 2
    // (faster) and solution 3 (fastest)
    
    // Some of these problems might have a better time and/or space
    // complexity if I was coding them in C++
    // However I enjoy the simplicity of Java over C++
    public String reverseWords(String s) {
        
        // Solution 1
        /*
        int i, j;
        for (i = 0; i < s.length(); i++)
        {
            for (j = i+1; j < s.length() && s.charAt(j) != ' '; j++);
            
            s = s.substring(0,i) + reverseWord(s.substring(i,j)) + s.substring(j);
            
            i = j;
        }
        */
        
        // Solution 2
        /*
        String[] splits = s.split("\\s+");
        s = "";
        
        for (int i = 0; i < splits.length; i++)
        {
            if (i != splits.length-1)
                s += reverseWord(splits[i]) + " ";
            else
                s += reverseWord(splits[i]);
        }
        
        return s;
        */
        
        // Solution 3 (seems to be the best)
        char[] str = s.toCharArray();
        int i, j;
        
        for (i = 0; i < str.length; i++)
        {
            for (j = i+1; j < str.length && str[j] != ' '; j++);
            
            reverseSubString(str, i, j);
            
            i = j;
        }
        
        return new String(str);
        
    }
    
    private String reverseWord(String word)
    {
        String output = "";
        
        for (int i = word.length()-1; i >= 0; i--)
        {
            output += word.charAt(i);
        }
        
        return output;
    }
    
    private void reverseSubString(char[] s, int startIndex, int endIndex) {
        for (int i = startIndex;  i < (endIndex+startIndex)/2; i++)
        {
            char c = s[i]; 
            s[i] = s[endIndex-(i-startIndex+1)];
            s[endIndex-(i-startIndex+1)] = c;
        }
    }
}