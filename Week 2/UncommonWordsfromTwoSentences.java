class Solution {
    
    // Overall runtime complexity should be O(n)
    // There is most likely a faster solution with less overhead,
    // but for the sake of time I will complete the problem this way.
    public String[] uncommonFromSentences(String A, String B) {
        String[] ey = A.split(" "); // O(n)
        String[] be = B.split(" "); // O(n)
        
        HashMap<String, Integer> words = new HashMap<String, Integer>();
        
        ArrayList<String> uncommonWords = new ArrayList<String>();
        
        for (int i = 0; i < ey.length; i++) // O(n)
        {
            if(words.containsKey(ey[i]))
                words.put(ey[i], (words.get(ey[i])+1));
            else
                words.put(ey[i], 1);
        }
        
        for (int i = 0; i < be.length; i++) // O(n)
        {
            if(words.containsKey(be[i]))
                words.put(be[i], (words.get(be[i])+1));
            else
                words.put(be[i], 1);
        }
        
        for (Map.Entry<String, Integer> entry : words.entrySet()) // O(n)
        {
            if (entry.getValue() == 1)
                uncommonWords.add(entry.getKey());
        }
        
        String[] output = new String[uncommonWords.size()];
        output = uncommonWords.toArray(output);
        
        return output;
        
    }
}