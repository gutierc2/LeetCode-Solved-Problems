class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = 
            new PriorityQueue<Map.Entry<Integer, Integer>>(
            new Comparator<Map.Entry<Integer, Integer>>(){
                public int compare(Map.Entry<Integer,Integer> i, Map.Entry<Integer,Integer> j)
                {
                    return j.getValue() - i.getValue();
                }
            });
        
        for (int i : nums)
        {
            if (map.containsKey(i))
            {
                map.put(i, map.get(i)+1);
            }
            else
            {
                map.put(i,1);
            }
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            maxHeap.add(entry);
        }
        
        List<Integer> output = new ArrayList<Integer>();
        
        for (int i = 0; i < k; i++)
        {
            output.add(maxHeap.poll().getKey());
        }
        
        return output;
    }
}