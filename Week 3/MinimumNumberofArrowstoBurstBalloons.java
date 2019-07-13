class Solution {
    public int findMinArrowShots(int[][] points) {
        int minArrows = 0;
        
        Arrays.sort(points, new Comparator<int[]>(){
            public int compare(int[] a, int[] b)
            {
                return Integer.compare(a[1], b[1]);
            }
        });
        
        for (int i = 0; i < points.length; i++)
        {
            int j = i+1;
            
            while ((j < points.length) 
                   && (points[i][1] >= points[j][0]))
            {
                j++;
            }
            
            minArrows++;
            i = j-1;
        }
        
        return minArrows;
    }
}