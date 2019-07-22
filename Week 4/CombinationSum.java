class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        combinationSum(output, candidates, new ArrayList<Integer>(), 0, target, 0);
        
        return output;
    }
    
    private void combinationSum(List<List<Integer>> output, int[] candidates, 
                                List<Integer> builder, int currentSum, 
                                int target, int startIndex)
    {
        
        if(currentSum == target)
        {
            output.add(new ArrayList<Integer>(builder));
        }
        else if (currentSum < target)
        {
            for(int i = startIndex; i < candidates.length; i++)
            {
                builder.add(candidates[i]);
                currentSum += candidates[i];
                combinationSum(output, candidates, builder, currentSum, target, i);
                currentSum -= builder.get(builder.size()-1);
                builder.remove(builder.size()-1);
            }
        }
    }
}