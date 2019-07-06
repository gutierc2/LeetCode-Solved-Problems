class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
        
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (sMap.containsKey(c))
            {
                sMap.put(c, sMap.get(c)+1);
            }
            else
            {
                sMap.put(c, 1);
            }
        }
        
        //List<Map.Entry<Character, Integer>> sList = new LinkedList<Character, Integer>(sMap);
        //Collections.sort(sList, Comparator.naturalOrder());
        
        StringBuilder sb = new StringBuilder();
        
        while(!sMap.isEmpty())
        {
            int biggestVal = 0;
            char biggestChar = 0;
            for (Map.Entry<Character, Integer> entry : sMap.entrySet())
            {
                if (entry.getValue() > biggestVal)
                {
                    biggestVal = entry.getValue();
                    biggestChar = entry.getKey();
                }
            }
            
            for(int i = 0; i < biggestVal; i++)
            {
                sb.append(biggestChar);
            }
            
            sMap.remove(biggestChar);
        }
        
        return sb.toString();
    }
}