class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        combine(output, new ArrayList<Integer>(), n, k, 1);
        
        return output;
    }
    
    private void combine(List<List<Integer>> output, List<Integer> builder, int n, int k, int s)
    {
        if (builder.size() != k)
        {
            for (int i = s; i <= n; i++)
            {
                builder.add(i);
                combine(output, builder, n, k, i+1);
                builder.remove(builder.size()-1);
            }
        }
        else
        {
            output.add(new ArrayList<Integer>(builder));
        }
    }
}