class Solution {
    
    // In order to solve this problem, I knew it would have to involve
    // some sort of bitwise operation. The very first thing to do would
    // be to XOR num with the value representing all 1's (i.e. 1111..1111)
    // which in this case is Integer.MAX_VALUE
    // Then we need to get rid of the leading 1's by shifting to the left
    // the number of original leading zeros and then shifting back by that
    // same number
    public int findComplement(int num) {
        
        if (num == 0)
            return 1;
        
        int numShifts = Integer.numberOfLeadingZeros(num);
        
        num = num ^ Integer.MAX_VALUE;
        
        num = (num << numShifts) >> numShifts;
        
        return num;
    }
}