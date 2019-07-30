class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] carr = new int[graph.length];
        
        for(int i = 0; i < graph.length; i++)
        {
            if (carr[i] == 0)
            {
                if(!isBipartite(graph,carr,i))
                    return false;
            }
        }
        
        return true;
    }
    
    private boolean isBipartite(int[][] graph, int[] carr, int vertex)
    {
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(vertex);
        carr[vertex] = 1;
        
        while(!queue.isEmpty())
        {
            int current = queue.remove();
            
            for (int i = 0; i < graph[current].length; i++)
            {
                if (carr[graph[current][i]] == 0)
                {
                    carr[graph[current][i]] = (carr[current] == 1) ? 2 : 1; 
                    queue.add(graph[current][i]);
                }
                else if (carr[graph[current][i]] == carr[current])
                    return false;
            }
        }
        
        return true;
    }
}