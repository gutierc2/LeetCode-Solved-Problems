class Solution {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> patMap = new HashMap<Character, String>();
        HashSet<String> vals = new HashSet<String>();
        String[] strList = str.split(" ");
        
        if (pattern.length() != strList.length)
            return false;
        
        for(int i = 0; i < pattern.length(); i++)
        {
            if(patMap.containsKey(pattern.charAt(i)))
            {
                if(!patMap.get(pattern.charAt(i)).equals(strList[i]))
                    return false;
            }
            else if (!vals.contains(strList[i]))
            {
                patMap.put(pattern.charAt(i), strList[i]);
                vals.add(strList[i]);
            }
            else
            {
                return false;
            }
        }
        
        return true;
    }
}