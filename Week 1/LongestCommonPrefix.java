class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        
        if (strs.length > 0)
        {
            int counter = 0;
            // for each letter in the first word
            for (int i = 0; i < strs[0].length(); i++)
            {
                // check each letter in every word
                for (int j = 0; j < strs.length; j++)
                {
                    if((i < strs[j].length()) && (strs[0].charAt(i) == strs[j].charAt(i)))
                    {
                        // Increment the counter when we get to the last word
                        if (j == strs.length-1)
                            counter++;
                    }
                    else // we break out of both loops
                    {
                        // I could have made use of the "break" statement here
                        // but I am always cautious of using break, especially
                        // in loops enclosed in loops such as in this case.
                        // In my opinion this solution is cleaner and we know
                        // exactly what is going to happen.
                        i = strs[0].length()-1;
                        j = strs.length-1;
                    }
                }
            }
            
            return strs[0].substring(0, counter);
        }
        
        return "";
    }
}