class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = buildGraph(numCourses, prerequisites);
        
        System.out.println(graph.toString());
        
        for (int i = 0; i < graph.size(); i++)
        {
            if (hasCycle(graph, i))
                return false;
        }
        
        return true;
    }
    
    private boolean hasCycle(List<List<Integer>> graph, int vertex)
    {
        if (graph.get(vertex).size() == 0)
            return false;
        
        boolean[] visited = new boolean[graph.size()];
        visited[vertex] = true;
        
        for(int i = 0; i < graph.get(vertex).size(); i++)
        {
            int current = graph.get(vertex).get(i);
            while(!graph.get(current).isEmpty())
            {
                if(visited[current])
                    return true;
                visited[current] = true;
                current = graph.get(current).get(0);
            }
            
            visited = new boolean[graph.size()];
            visited[vertex] = true;
        }
        
        return false;
    }
    
    private List<List<Integer>> buildGraph(int numCourses, int[][] prerequisites)
    {
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        
        for(int i = 0; i < numCourses; i++)
        {
            graph.add(new ArrayList<Integer>());
        }
        
        for(int[] i : prerequisites)
        {
            graph.get(i[0]).add(i[1]);
        }
        
        return graph;
    }
}