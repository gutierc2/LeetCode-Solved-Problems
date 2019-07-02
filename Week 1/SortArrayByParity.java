class Solution {
    // My approach to this problem will be to find a solution that does not
    // involve having to put together multiple arrays...
    
    // We can solve this problem in O(n) time and space by keeping track of
    // an even index and an odd index
    
    // The odd index starts at the end while the even index starts at the 
    // beginning of the array we want to return
    public int[] sortArrayByParity(int[] A) {
        int evenIndex = 0;
        int oddIndex = A.length-1;
        
        int[] result = new int[A.length];
        
        for (int i = 0; i < A.length; i++)
        {
            if (A[i] % 2 == 0)
            {
                result[evenIndex] = A[i];
                evenIndex++;
            }
            else
            {
                result[oddIndex] = A[i];
                oddIndex--;
            }
        }
        
        return result;
    }
}