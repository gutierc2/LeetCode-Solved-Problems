class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;
        
        ArrayList<int[]> a = new ArrayList<int[]>();
        
        Arrays.sort(intervals, new Comparator<int[]>(){
                        public int compare(int[] a, int[] b)
                        {
                            return Integer.compare(a[0], b[0]);
                        }
                    });
        
        int[] currentMerge = intervals[0];
        
        for (int i = 1; i < intervals.length; i++)
        {
            if (intervals[i][0] <= currentMerge[1])
                currentMerge = mergeArrays(currentMerge, intervals[i]);
            else
            {
                a.add(currentMerge);
                currentMerge = intervals[i];
            }
        }
        
        if (a.size() == 0 || 
            intervals[intervals.length-1][1] != a.get(a.size()-1)[1])
            a.add(currentMerge);
        
        return arrayListTo2dArray(a);
        
    }
    
    private int[][] arrayListTo2dArray(ArrayList<int[]> a)
    {
        int[][] output = new int[a.size()][2];
        
        for (int i = 0; i < a.size(); i++)
        {
            output[i] = a.get(i);
        }
        
        return output;
    }
    
    private int[] mergeArrays(int[] a, int[] b)
    {
        if (b[1] > a[1])
        {
            int[] arr = {a[0], b[1]};
            return arr;
        }
        
        int[] arr = {a[0], a[1]};
        return arr;
        
    }
}