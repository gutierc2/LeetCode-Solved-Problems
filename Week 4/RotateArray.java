class Solution {
    public void rotate(int[] nums, int k) {
        ArrayDeque<Integer> numsQ = new ArrayDeque<Integer>();
        
        k = k % nums.length;
        
        for(int i = 0; i < nums.length; i++)
        {
            int j = (i + nums.length-k) % nums.length;
            
            numsQ.add(nums[j]);
        }
        
        for (int i = 0; i < nums.length; i++)
        {
            nums[i] = numsQ.pop();
        }
    }
}