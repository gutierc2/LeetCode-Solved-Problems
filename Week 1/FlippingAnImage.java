class Solution {
    // Again my approach to this problem is to solve it in
    // as few passes through A as possible
    
    // There may be a way to solve the problem using less memory
    
    // Essentially my approach is to create another 2D array
    // the same size as A, and then check each row of A.
    // For each element in each row
    // We compute an 'oppositeIndex' and assign the corresponding
    // element in the new 2D array the opposite value of the 
    // element in the opposite Index of A
    // (Much easier to explain in person)
    
    public int[][] flipAndInvertImage(int[][] A) {
        
        int[][] updatedImg = new int[A.length][A[0].length];
        
        for (int i = 0; i < A.length; i++)
        {
            updatedImg[i] = flipAndInvertRow(A[i]);
        }
        
        return updatedImg;
    }
    
    private int[] flipAndInvertRow(int[] row)
    {
        int[] flippedRow = new int[row.length];
        
        for (int i = 0; i < row.length; i++)
        {
            int oppIndex = row.length-i-1;
            flippedRow[i] = (row[oppIndex] == 1) ? 0 : 1;
        }
        
        return flippedRow;
    }
    
    
}