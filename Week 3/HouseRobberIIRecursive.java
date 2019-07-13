class Solution {
    public int rob(int[] nums) {
        
        if(nums.length == 0)
            return 0;
        
        if(nums.length == 1)
            return nums[0];
        
        int[] robbed = new int[nums.length+1];
        Arrays.fill(robbed, -1);
        
        // We first look for a solution involving the last element
        // and not involving the first
        int temp = nums[0];
        nums[0] = 0;
        int rob1 = rob(nums, robbed, nums.length-1);
        
        // Then we look for a solution involving the first element
        // and not the last (since they are neighbors)
        Arrays.fill(robbed,-1);
        nums[0] = temp;
        int rob2 = rob(nums, robbed, nums.length-2);
        
        // Then we return the greater of the two solutions
        return Math.max(rob1, rob2);
    }
    
    private int rob(int[] nums, int[] robbed, int house)
    {
        if (house < 0)
            return 0;
        
        int result = 0;
        
        if (robbed[house] > -1)
            result = robbed[house];
        else
        {
            result = Math.max(nums[house] + rob(nums, robbed, house-2),
                        rob(nums, robbed, house-1));
            robbed[house] = result;
        }
        
        return result;
    }
}