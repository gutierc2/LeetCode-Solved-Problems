class Solution {
    
    // This was another one of those problems where if you know how
    // bit manipulation works, solving the problem is only a matter of
    // thinking about how the logic will work and then coding it.
    
    // The memory usage results for this problem are also disappointing
    // Not sure how to improve on that
    public int binaryGap(int N) {
        int longest = 0;
        int currentLongest = 0;
        
        // Find the first 1 from the right in the binary representation
        while(N % 2 == 0)// Non-bracketed while loops make me uncomfortable
        {
            N = N >> 1;
        }
           
        N = N >> 1; // shift to the next bit
        
        while(N != 0) // while we still have 1's in the binary number
        {
            currentLongest++;
            if (N % 2 != 0) // if we run into another 1
            {   // if the current distance is longer than a previous distance
                if (currentLongest > longest)
                {   // set our longest to the current longest
                    longest = currentLongest;
                }
                currentLongest = 0; // reset current longest counter
            }
            N = N >> 1;
        }
        
        return longest;
    }
}