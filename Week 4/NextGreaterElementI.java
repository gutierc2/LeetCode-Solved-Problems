class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        
        for (int n : nums2)
        {
            while(!stack.isEmpty() && n > stack.peek())
                map.put(stack.pop(), n);
            
            stack.push(n);
        }
        
        int[] output = new int[nums1.length];
        
        for(int i = 0; i < nums1.length; i++)
        {
            if (map.containsKey(nums1[i]))
                output[i] = map.get(nums1[i]);
            else
                output[i] = -1;
        }
        
        return output;
    }
}