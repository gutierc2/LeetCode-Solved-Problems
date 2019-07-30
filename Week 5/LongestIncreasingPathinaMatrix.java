class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        
        if (matrix.length == 0)
            return 0;
        
        int[][] memo = new int[matrix.length][matrix[0].length];
        
        int max = 1;
        
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[i].length; j++)
            {
                int temp = longestIncreasingPath(matrix, i, j, memo);
                if (temp > max)
                    max = temp;
            }
        }
        
        return max;
    }
    
    private int longestIncreasingPath(int[][] matrix, int vr, int vc, int[][] memo)
    {
        if (memo[vr][vc] != 0)
            return memo[vr][vc];
        
        int top = vr-1;
        int bot = vr+1;
        int left = vc-1;
        int right = vc+1;
        
        int current = matrix[vr][vc];
        int path = 1;
        
        if (top >= 0 && top < matrix.length)
        {
            if (matrix[top][vc] > current)
            {
                int topPath = longestIncreasingPath(matrix, top, vc, memo)+1;
                
                if (topPath > path)
                    path = topPath;
            }
        }
        
        if (bot >= 0 && bot < matrix.length)
        {
            if (matrix[bot][vc] > current)
            {
                int botPath = longestIncreasingPath(matrix, bot, vc, memo)+1;
                
                if (botPath > path)
                    path = botPath;
            }
        }
        
        if (left >= 0 && left < matrix[vr].length)
        {
            if (matrix[vr][left] > current)
            {
                int leftPath = longestIncreasingPath(matrix, vr, left, memo)+1;
                
                if (leftPath > path)
                    path = leftPath;
            }
        }
        
        if (right >= 0 && right < matrix[vr].length)
        {
            if (matrix[vr][right] > current)
            {
                int rightPath = longestIncreasingPath(matrix, vr, right, memo)+1;
                
                if (rightPath > path)
                    path = rightPath;
            }
        }
        
        memo[vr][vc] = path;
        
        return path;
    }
}