class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();
        HashSet<String> bannedSet = new HashSet<String>();
        HashMap<String, Integer> pMap = new HashMap<String, Integer>();
        
        for (String s : banned)
        {
            bannedSet.add(s);
        }
        
        String[] p = paragraph.split("\\s+");
        
        for(String s : p)
        {
            if (!bannedSet.contains(s))
            {
                if (pMap.containsKey(s))
                {
                    pMap.put(s, pMap.get(s)+1);
                }
                else
                {
                    pMap.put(s, 1);
                }
            }
        }
        
        String mc = "";
        int mcoccurences = 0;
        
        for(Map.Entry<String, Integer> entry : pMap.entrySet())
        {
            if (entry.getValue() > mcoccurences)
            {
                mc = entry.getKey();
                mcoccurences = entry.getValue();
            }
        }
        
        return mc;
    }
}