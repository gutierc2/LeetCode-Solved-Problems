class Solution {
    
    
    public int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >= 0; i--)
        {
            if (digits[i] + 1 > 9)
                digits[i] = 0;
            else
            {
                digits[i]++;
                break;
            }
        }
        
        // This is in case an extra digit needs to be added
        // This could have potentially been its own function
        // for the purpose of clarity, but I feel this way
        // may save space and is a change of pace from my usual
        // coding style.
        
        // I want to be able to adapt to any coding style a
        // potential employer may ask of me, this is only a small
        // example of that adabtability/desire to learn.
        if (digits[0] == 0)
        {
            int[] expandedDigits = new int[digits.length+1];
            expandedDigits[0] = 1;
            
            for (int i = 0; i < digits.length; i++)
            {
                expandedDigits[i+1] = digits[i];
            }
            
            return expandedDigits;
        }
        
        return digits;
    }
}