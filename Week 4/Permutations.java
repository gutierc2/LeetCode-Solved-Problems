class Solution {
    // Based on the previous problem I worked on (subsets)
    // I was able to come up with a solution to this problem
    // It seems these problems follow a general backtracking
    // methodology that I can potentially keep implementing
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        //List<Integer> builder = new ArrayList<Integer>();
        
        permute(output, new ArrayList<Integer>(), nums);
        
        return output;
        
    }
    
    private void permute(List<List<Integer>> output, List<Integer> builder, 
                         int[] nums)
    {
        if (builder.size() != nums.length)
        {
            for(int i = 0; i < nums.length; i++)
            {
                if (!builder.contains(nums[i]))
                {
                    builder.add(nums[i]);
                    permute(output, builder, nums);
                    builder.remove(builder.size()-1);
                }
            }
        }
        else
        {
            output.add(new ArrayList<Integer>(builder));
        }
        
        
    }
}