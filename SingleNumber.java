class Solution {
    public int singleNumber(int[] nums) {
        int answer = -1;
        
        for (int i = 0; i < nums.length; i++)
        {
            for (int j = i+1; j < nums.length; j++)
            {
                if (nums[i] == nums[j])
                {
                    swap(nums,i+1,j);
                    j = nums.length-1;
                    i++;
                }
                else if (j == nums.length-1)
                {
                    answer = nums[i];
                    j = nums.length-1;
                    i = nums.length-1;
                }
            }
        }
        
        if (answer == -1)
            answer = nums[nums.length-1];
        
        return answer;
    }
    
    public void swap(int[] nums, int first, int second)
    {
        int i = nums[first];
        nums[first] = nums[second];
        nums[second] = i;
    }
    
}