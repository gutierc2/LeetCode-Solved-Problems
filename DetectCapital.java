class Solution {
    // By checking the first two letters of the word, we get an
    // idea about what the rest of the word should look like
    
    public boolean detectCapitalUse(String word) {
        // If the first letter is a capital letter
        if (((int) word.charAt(0)) >= 65 && ((int) word.charAt(0)) <= 90)
        {
            if (word.length() > 1)
            {
                // If the second letter is a capital letter
                if (((int) word.charAt(1)) >= 65 && ((int) word.charAt(1)) <= 90)
                {
                    for (int i = 2; i < word.length(); i++)
                    {
                        // If the any of the rest of the letters are lowercase, capital
                        // usage is wrong
                        if (((int) word.charAt(i)) < 65 || ((int) word.charAt(i)) > 90)
                            return false;
                    }
                }
                else // second letter is lowercase
                {
                    for (int i = 2; i < word.length(); i++)
                    {
                        // If the rest of the letters are not lowercase, capital
                        // usage is wrong
                        if (((int) word.charAt(i)) >= 65 && ((int) word.charAt(i)) <= 90)
                            return false;
                    }
                }
            }
        }
        else // first letter is not capital
        {
            for (int i = 1; i < word.length(); i++)
            {
                // If the rest of the letters are not lowercase, capital
                // usage is wrong
                if (((int) word.charAt(i)) >= 65 && ((int) word.charAt(i)) <= 90)
                    return false;
            }
        }
        
        return true;
    }
}