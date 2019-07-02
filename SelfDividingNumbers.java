class Solution {
    
    // It's been a while since I used the mod operator so this problem took
    // me a little longer than it should have.
    
    // I typically take the cleanest looking, easiest to read approach when
    // it comes to coding. For this problem, figuring out whether a number is
    // self-dividing or not seemed to best fit inside its own function.
    // Once that function was written, the rest was relatively trivial.
    
    // I first used an ArrayList for the problem, but looking at the submission
    // results I figured using LinkedList may use less space.
    
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> selfDividingList = new LinkedList<Integer>();
        
        for (int i = left; i <= right; i++)
        {
            if (isSelfDividingNumber(i))
                selfDividingList.add(i);
        }
        
        return selfDividingList;
    }
    
    private boolean isSelfDividingNumber(int num)
    {
        if ((num < 10) && (num > 0))
            return true;
        
        int numCopy = num;
        
        while(numCopy > 0)
        {
            int digit = numCopy % 10;
            
            if ((digit == 0) || (num % digit != 0))
                return false;
            
            numCopy = numCopy/10;
        }
        
        return true;
    }
}