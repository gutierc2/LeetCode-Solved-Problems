class Solution {
    // This was another difficult problem for me..
    // I knew it involved backtracking, but I could not figure out
    // how to incorporate backtracking. All the solutions I could think of
    // involved doing more work than was necessary (i.e. a recursive solution that
    // would redo work at every step).
    
    // I looked at the discussion page for help with this problem.
    // Once I did the algorithm by hand, it was easy to implement my own
    // (similar) solution.

    // The rest of the combination problems I will attempt without
    // looking at the discussions page
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        List<Integer> builder = new ArrayList<Integer>();
        
        subsets(output, builder, nums, 0);
        
        return output;
        
    }
    
    private void subsets(List<List<Integer>> output, List<Integer> builder, int[] nums, int startIndex)
    {
        output.add(new ArrayList<Integer>(builder));
        for(int i = startIndex; i < nums.length; i++)
        {
            builder.add(nums[i]);
            subsets(output, builder, nums, i+1);
            builder.remove(builder.size()-1);
        }
    }
}