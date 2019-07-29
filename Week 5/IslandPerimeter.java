class Solution {
    // This problem might be looked at as a graph
    // problem. But my solution does not involve the
    // use of graphs.
    public int islandPerimeter(int[][] grid) {
        
        int output = 0;
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0 ; j < grid[i].length; j++)
            {
                output += perimeter(grid, i, j);
            }
        }
        
        return output;
    }
    
    private int perimeter(int[][] grid, int r, int c)
    {
        if (grid[r][c] == 0)
            return 0;
        
        int cl = grid[0].length;
        int rl = grid.length;
        
        int p = 0;
        
        if (c-1 >= 0 && grid[r][c-1] == 0)
            p++;
        else if (c-1 < 0)
            p++;
        
        if (r-1 >= 0 && grid[r-1][c] == 0)
            p++;
        else if (r-1 < 0)
            p++;
        
        if (c+1 < cl && grid[r][c+1] == 0)
            p++;
        else if (c+1 >= cl)
            p++;
        
        if (r+1 < rl && grid[r+1][c] == 0)
            p++;
        else if (r+1 >= rl)
            p++;
        
        return p;
    }
}