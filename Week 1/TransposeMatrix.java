class Solution {
    
    // Admittedly my linear algebra is a tad rusty.
    // I managed to solve this problem by observing the
    // pattern with the input and outputs in the problem
    // statement.
    
    // I noticed that the number of arrays in the output list is
    // equal to the number of elements in each of the arrays in
    // the input list. From there it was just a matter of figuring
    // out the correct way to copy the elements into the new list
    
    public int[][] transpose(int[][] A) {
        int[][] result = new int[A[0].length][A.length];
        
        for (int i = 0; i < result[0].length; i++)
        {
            for (int j = 0; j < result.length; j++)
            {
                result[j][i] = A[i][j];
            }
        }
        
        return result;
    }
}