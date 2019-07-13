class Solution {
    public boolean lemonadeChange(int[] bills) {
        
        int numFives = 0;
        int numTens = 0;
        
        for (int i = 0; i < bills.length; i++)
        {
            int bill = bills[i];
            
            if (bill == 20)
            {
                if (numTens >= 1 && numFives >= 1)
                {
                    numTens--;
                    numFives--;
                }
                else if (numFives >= 3)
                {
                    numFives -= 3;
                }
                else
                {
                    return false;
                }
            }
            else if (bill == 10)
            {
                if(numFives >= 1)
                {
                    numFives--;
                }
                else
                {
                    return false;
                }
                
                numTens++;
            }
            else
            {
                numFives++;
            }
            
        }
        
        return true;
    }
}