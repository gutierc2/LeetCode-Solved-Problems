class Solution {
    
    // For this problem I attempted a solution involving
    // DFS and Union-Find, however when I run it, I get time
    // limit exceeded. I believe this solution might have an infinite
    // loop for a certain input, but I'm not sure where it is originating.
    // My suspicion is that is has to do with my union-find method.
    // It gives me time limit exceeded for the input at the bottom of this
    // class.
    
    
    private int[] parent;
    
    public int numIslands(char[][] grid) {
        
        if (grid.length == 0)
            return 0;
        if (grid[0].length == 0)
            return 0;
        
        //int[][] grid2 = convertCharArrayToIntArray(grid);
        
        parent = new int[grid.length * grid[0].length];
        
        Arrays.fill(parent, -1);
        
        dfsUnion(grid, 0, 0);
        
        return countCircles(grid);
        
    }

    private void dfsUnion(char[][] grid2, int i, int j)
    {
        if (i < grid2.length && j < grid2[0].length)
        {
            if (grid2[i][j] == '1')
            {
                int vertex1 = i * grid2[0].length + j;

                if ((i+1) < grid2.length && grid2[i+1][j] == '1')
                {
                    int vertex2 = (i+1) * grid2[0].length + j;

                    union(vertex1, vertex2);
                }

                if ((j+1) < grid2[0].length && grid2[i][j+1] == '1')
                {
                    int vertex2 = i * grid2[0].length + (j+1);

                    union(vertex1, vertex2);
                }
            }
        
            dfsUnion(grid2, i+1, j);
            dfsUnion(grid2, i, j+1);
        }
        
        
    }
    
    /*
    private int numOnes(int[][] grid2)
    {
        int count = 0;
        
        for(int i = 0; i < grid2.length; i++)
        {
            for (int j = 0; j < grid2[0].length(); j++)
            {
                if (grid2[i][j] == 1)
                    count++;
            }
        }
        
        return count;
    }
    */
    
    private int countCircles(char[][] grid2)
    {
        int count = 0;
        
        for (int i = 0; i < parent.length; i++)
        {
            int c = i % grid2[0].length;
            int r = (i - c) / grid2[0].length;
            if (parent[i] == -1 && grid2[r][c] != '0')
            {
                count++;
            }
        }
        
        return count;
    }
    /*
    private int[][] convertCharArrayToIntArray(char[][] grid)
    {
        int[][] output = new int[grid.length][grid[0].length];
        
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                output[i][j] =  Character.getNumericValue(grid[i][j]);
            }
        }
        
        return output;
    }
    */
    private int find(int vertex)
    {
        while (parent[vertex] != -1)
        {
            vertex = parent[vertex];
        }
        
        return vertex;
    }
    
    private void union(int vertex1, int vertex2)
    {
        if (find(vertex1) != find(vertex2))
        {
            parent[find(vertex1)] = find(vertex2);
        }
    }
    
    /*[["1","0","0","1","1","1","0","1","1","0","0","0","0","0","0","0","0","0","0","0"],["1","0","0","1","1","0","0","1","0","0","0","1","0","1","0","1","0","0","1","0"],["0","0","0","1","1","1","1","0","1","0","1","1","0","0","0","0","1","0","1","0"],["0","0","0","1","1","0","0","1","0","0","0","1","1","1","0","0","1","0","0","1"],["0","0","0","0","0","0","0","1","1","1","0","0","0","0","0","0","0","0","0","0"],["1","0","0","0","0","1","0","1","0","1","1","0","0","0","0","0","0","1","0","1"],["0","0","0","1","0","0","0","1","0","1","0","1","0","1","0","1","0","1","0","1"],["0","0","0","1","0","1","0","0","1","1","0","1","0","1","1","0","1","1","1","0"],["0","0","0","0","1","0","0","1","1","0","0","0","0","1","0","0","0","1","0","1"],["0","0","1","0","0","1","0","0","0","0","0","1","0","0","1","0","0","0","1","0"],["1","0","0","1","0","0","0","0","0","0","0","1","0","0","1","0","1","0","1","0"],["0","1","0","0","0","1","0","1","0","1","1","0","1","1","1","0","1","1","0","0"],["1","1","0","1","0","0","0","0","1","0","0","0","0","0","0","1","0","0","0","1"],["0","1","0","0","1","1","1","0","0","0","1","1","1","1","1","0","1","0","0","0"],["0","0","1","1","1","0","0","0","1","1","0","0","0","1","0","1","0","0","0","0"],["1","0","0","1","0","1","0","0","0","0","1","0","0","0","1","0","1","0","1","1"],["1","0","1","0","0","0","0","0","0","1","0","0","0","1","0","1","0","0","0","0"],["0","1","1","0","0","0","1","1","1","0","1","0","1","0","1","1","1","1","0","0"],["0","1","0","0","0","0","1","1","0","0","1","0","1","0","0","1","0","0","1","1"],["0","0","0","0","0","0","1","1","1","1","0","1","0","0","0","1","1","0","0","0"]]*/
}