class Solution {
    public int maxProfit(int[] prices) {
        
        if (prices.length == 0)
            return 0;
        
        
        int lowestPrice = prices[0];
        int maxProf = 0;
        
        for(int i = 1; i < prices.length; i++)
        {
            lowestPrice = Math.min(lowestPrice, prices[i-1]);
            maxProf = Math.max(maxProf, prices[i]-lowestPrice);
        }
        
        return maxProf;
    }
}