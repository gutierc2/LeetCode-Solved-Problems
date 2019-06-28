class Solution {
    
    // The approach I took with this problem the first time around (commented out) was
    // the trivial approach, go through every element, testing the following
    // elements one by one until we find a solution.
    
    // Since this problem was under the "HashMap" category, I figured a better solution
    // had something to do with HashMaps or sets. Since with this problem we clearly have
    // key-value relationships, I believed it be best to find a solution involving HashMap
    
    // Typically, if we are looking to lower time complexity, we want to avoid performing
    // as many O(n) operations as possible. Thus, I tried to find a solution that avoided
    // the use of the "containsValue" HashMap method as it is O(n). Additionally, this
    // approach made it much easier to find the key of a particular value, also saving time.
    
    // This may not be the most optimal solution, but it is the best I can think of 
    // at the moment.
    public int[] twoSum(int[] nums, int target) {
        
        // Contains input numbers as keys and indices as values
        HashMap<Integer, Integer> numsMap = new HashMap<Integer, Integer>(nums.length, 1.1f);
        
        int[] output = new int[2];
        
        for (int i = 0; i < nums.length; i++)
        {
            numsMap.put(nums[i], i);
        }
        
        for (int i = 0; i < nums.length; i++)
        {
            if(numsMap.containsKey(target-nums[i]) && (i != numsMap.get(target-nums[i])))
            {
                output[0] = i;
                output[1] = numsMap.get(target-nums[i]);
                break;
            }
        }
        
        return output;
        
        
        /*
        int[] output = new int[2];
        
        for (int i = 0; i < nums.length; i++)
        {
            for (int j = i+1; j < nums.length; j++)
            {
                if (nums[i] + nums[j] == target)
                {
                    output[0] = i;
                    output[1] = j;
                }
            }
        }
        
        return output;
    */
        
        
    }
}