class Solution {
    public double myPow(double x, int n) {
        if (n == 1)
            return x;
        
        if (n == 0)
            return 1;
        
        if (n < 0)
            return 1/x * myPow(1/x, -1*(n+1));
        
        double a = myPow(x, n/2);
        
        if (n%2 == 0)
            return a*a;
        
        return x*a*a;
    }
}