class Solution {
    public int maxProfit(int[] prices) {
        
        if (prices.length <= 1)
            return 0;
        
        int[] arr = diffArr(prices);
        
        int[] msa = maxSubarray(arr, 0, arr.length-1);
        
        int output = prices[msa[1]+1] - prices[msa[0]];
        
        return (output < 0) ? 0 : output;
    }
    
    private int[] diffArr(int[] prices)
    {
        int[] arr = new int[prices.length-1];
        
        for(int i = prices.length-1; i >= 1; i--)
        {
            arr[i-1] = prices[i]-prices[i-1];
        }
        
        return arr;
    }
    
    private int[] maxSubarray(int[] prices, int low, int high)
    {
        if (high == low)
            return new int[]{low, high, prices[low]};
        
        int mid = (low+high)/2;
        int[] leftMax = maxSubarray(prices, low, mid);
        int[] rightMax = maxSubarray(prices, mid+1, high);
        int[] crossMax = maxCrossSubarray(prices, low, mid, high);
        
        if (leftMax[2] >= rightMax[2] && leftMax[2] >= crossMax[2])
            return leftMax;
        else if (rightMax[2] >= leftMax[2] && rightMax[2] >= crossMax[2])
            return rightMax;
        else
            return crossMax;
    }
    
    private int[] maxCrossSubarray(int[] prices, int low, int mid, int high)
    {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        int maxLeft = 0;
        for(int i = mid; i >= low; i--)
        {
            sum += prices[i];
            if(sum > leftSum)
            {
                leftSum = sum;
                maxLeft = i;
            }
        }
        
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        int maxRight = 0;
        for (int i = mid+1; i <= high; i++)
        {
            sum += prices[i];
            if (sum > rightSum)
            {
                rightSum = sum;
                maxRight = i;
            }
        }
        
        return new int[]{maxLeft, maxRight, leftSum+rightSum};
    }
}