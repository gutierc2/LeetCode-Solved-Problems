class Solution {
    
    // memory usage stats for this solution are rather poor,
    // but I'm not too sure on how to improve on them
    public int hammingDistance(int x, int y) {
        int output = 0;
        
        while (x != 0 || y != 0)
        {
            if((x + y) % 2 != 0)
                output++;
            x = x >> 1;
            y = y >> 1;
        }
        
        return output;
    }
}