class Solution {
    
    // This problem was a bit of a challenge for me as
    // I had never come across a union find problem
    // before. The video at https://www.geeksforgeeks.org/union-find/
    // was very helpful in figuring out this problem.
    
    // to solve it we essentially perform the union find
    // algorithm and count the total number of parents (i.e. disjoint sets)
    
    
    private int[] parent;
    
    public int findCircleNum(int[][] M) {
        parent = new int[M[0].length];
        Arrays.fill(parent, -1);
        
        for (int i = 0; i < M.length; i++)
        {
            for (int j = i+1; j < M.length; j++)
            {
                if (M[i][j] == 1 && find(i) != find(j))
                {
                    union(i, j);
                }
            }
        }
        
        return countCircles();
    }
    
    private int countCircles()
    {
        int count = 0;
        
        for (int i = 0; i < parent.length; i++)
        {
            if (parent[i] == -1)
                count++;
        }
        
        return count;
    }
    
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
        parent[find(vertex1)] = find(vertex2);
    }
}