class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> sdMap = new HashMap<String, Integer>();
        List<String> output = new ArrayList<String>();
        
        for (int i = 0; i < cpdomains.length; i++)
        {
            String[] sp = cpdomains[i].split(" ");
            int amt = Integer.parseInt(sp[0]);
            
            if (sdMap.containsKey(sp[1]))
            {
                sdMap.put(sp[1], sdMap.get(sp[1])+amt);
            }
            else
            {
                sdMap.put(sp[1], amt);
            }
            
            String[] dms = sp[1].split("[.]+");
            
            if (dms.length == 2)
            {
                if (sdMap.containsKey(dms[1]))
                {
                    sdMap.put(dms[1], sdMap.get(dms[1])+amt);
                }
                else
                {
                    sdMap.put(dms[1], amt);
                }
            }
            else
            {
                String k = dms[1] + "." + dms[2];
                
                if (sdMap.containsKey(k))
                {
                    sdMap.put(k, sdMap.get(k)+amt);
                }
                else
                {
                    sdMap.put(k, amt);
                }
                
                if (sdMap.containsKey(dms[2]))
                {
                    sdMap.put(dms[2], sdMap.get(dms[2])+amt);
                }
                else
                {
                    sdMap.put(dms[2], amt);
                }
            }
        }
        
        for (Map.Entry<String, Integer> entry : sdMap.entrySet())
        {
            String a = entry.getValue() + " " + entry.getKey();
            
            output.add(a);
        }
        
        return output;
    }
}