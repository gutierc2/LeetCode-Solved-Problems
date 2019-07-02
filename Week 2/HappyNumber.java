class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> numsSet = new HashSet<Integer>();
        
        int squareDig = sumOfSquareOfDigits(n);
        
        while (squareDig != 1)
        {
            numsSet.add(squareDig);
            squareDig = sumOfSquareOfDigits(squareDig);
            if (numsSet.contains(squareDig))
                return false;
        }
        
        return true;
        
    }
    
    private int sumOfSquareOfDigits(int n)
    {
        int sum = 0;
        int dig = n % 10;
        
        while (n > 0)
        {
            sum += dig*dig;
            n = n / 10;
            dig = n % 10;
        }
        
        return sum;
    }
}