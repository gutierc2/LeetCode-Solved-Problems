class Solution {
    public int rob(int[] nums) {
        
        if(nums.length == 0)
            return 0;
        
        if(nums.length == 1)
            return nums[0];
        
		int temp = nums[0];
		nums[0] = 0;
		
		int p1 = 0;
		int p2 = 0;
		
		int max1 = 0;
		int max2 = 0;
		
		for(int i = 0; i < nums.length; i++)
		{
			int t = p1;
			p1 = Math.max(p2+nums[i],p1);
			p2 = t;
		}
		
		max1 = p1;
		
		nums[0] = temp;
		nums[nums.length-1] = 0;
        
        p1 = 0;
        p2 = 0;
		
		for(int i = 0; i < nums.length; i++)
		{
			int t = p1;
			p1 = Math.max(p2+nums[i],p1);
			p2 = t;
		}
		
		max2 = p1;
        
		
        return Math.max(max1, max2);
    }
}