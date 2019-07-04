class Solution {
    // My approach to this problem is to place all the elements
    // of each array into their own hashset, go through all the elements
    // in one of the sets and check if they are in the other set,
    // if they are, we add it to a list and return the result.
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> nums1Set = new HashSet<Integer>();
        HashSet<Integer> nums2Set = new HashSet<Integer>();
        
        for (int i : nums1)
        {
            nums1Set.add(i);
        }
        
        for (int i : nums2)
        {
            nums2Set.add(i);
        }
        
        ArrayList<Integer> output = new ArrayList<Integer>();
        Iterator<Integer> it = nums1Set.iterator();
        
        while(it.hasNext())
        {
            int c = it.next();
            if (nums2Set.contains(c))
                output.add(c);
        }
        
        int[] outputArr = new int[output.size()];
        
        for (int i = 0; i < output.size(); i++)
        {
            outputArr[i] = output.get(i);
        }
        
        return outputArr;
    }
}