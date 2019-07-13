class Solution {
    public int search(int[] nums, int target) {
        return iterativeBinarySearch(nums, target, 0, nums.length-1);
    }
    
    private int iterativeBinarySearch(int[] nums, int target, int low, int high)
    {
        while (low <= high)
        {
            int mid = (low + high)/2;
            
            if (target == nums[mid])
                return mid;
            else if (target > nums[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
    
        return -1;
    }
        
}