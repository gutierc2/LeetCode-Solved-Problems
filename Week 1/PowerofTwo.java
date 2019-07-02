class Solution {
    // For this problem, there is a trivial method that
    // takes longer to solve, and that is to to try every
    // 2^x from 0 until we get our input or surpass our input
    // (another solution involves division and %)
    
    // Right off the bat I knew this solution would be too slow.
    // I also knew that there was a simpler solution involving
    // logarithms. However, I wasn't sure exact how logs were
    // involved so unfortunately I had to look it up to get to
    // the solution
    
    // After having arrived at a solution involving logarithms, it
    // turned out that the solution did not work for certain inputs
    // (536870912). Upon further investigation, I came upon a solution
    // involving bit comparison that was much simpler and cleaner
    // that I had not realized. (seen below)
    public boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
        
        // If n is a power of 2, log base 2 of n will be a round number
        // If the ceiling and floor of log base 2 of n are the same,
        // then it is a round number and n is a power of 2
       // return ((int) Math.ceil(Math.log(n)/Math.log(2))) == ((int) Math.floor(Math.log(n)/Math.log(2)));
        
        
        // While thinking about this solution, it makes perfect sense.
        // If n is a power of 2, that means only 1 bit in the number is
        // "on" (e.g. 4 = 100, 8 = 1000, etc..) and if we subtract 1 from that
        // number we get all the other (previous) bits turned on (e.g. 4-1=3=011, 
        // 8-1=7=0111, etc..). When we "&" these numbers together we should
        // get 0, if we don't, then the number is not a power of 2
        
        
        return ((n & (n - 1)) == 0);
        
        // Source: https://stackoverflow.com/questions/600293/how-to-check-if-a-number-is-a-power-of-2
    }
}