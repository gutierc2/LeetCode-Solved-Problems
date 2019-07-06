class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] output = new int[2];
        
        HashSet<Integer> numSet = new HashSet<Integer>();
        
        for (int i : nums)
        {
            if (numSet.contains(i))
                output[0] = i;
            
            numSet.add(i);
        }
        
        for (int i = 1; i <= nums.length; i++)
        {
            if(!numSet.contains(i))
                output[1] = i;
        }
        
        return output;
    }
}