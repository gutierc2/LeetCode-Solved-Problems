class Solution {
    public int minDistance(String word1, String word2) {
        
        int w1Len = word1.length();
        int w2Len = word2.length();
        
        int[][] dist = new int[w1Len+1][w2Len+1];
        
        dist[0][0] = 0;
        
        for(int i = 1; i < w1Len+1; i++)
        {
            dist[i][0] = i;
        }
        
        for(int i = 1; i < w2Len+1; i++)
        {
            dist[0][i] = i;
        }
        
        for(int i = 1; i < w1Len+1; i++)
        {
            for(int j = 1; j < w2Len+1; j++)
            {
                char w1Char = word1.charAt(i-1);
                char w2Char = word2.charAt(j-1);
                
                if (w1Char == w2Char)
                    dist[i][j] = dist[i-1][j-1];
                else
                {
                    int min = Math.min(Math.min(dist[i-1][j], dist[i][j-1]), dist[i-1][j-1]);
                    dist[i][j] = min+1;
                }
            }
        }
        
        return dist[w1Len][w2Len];
    }
    
    
}