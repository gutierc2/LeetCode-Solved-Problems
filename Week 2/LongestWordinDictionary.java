class Solution {
    
    // **** Not done ****
    // First time coding with Tries, took longer than expected
    private class TrieNode
    {
        HashMap<Character, TrieNode> children;
        char val;
        boolean isWord;
        
        public TrieNode(){
            val = (char) 0;
            isWord = false;
            children = new HashMap<Character, TrieNode>();
        }
        
        public TrieNode(val)
        {
            this.val = val;
            children = new HashMap<Character, TrieNode>();
            isWord = false;
        }
    }
    
    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        
        for (int i = 0; i < words.length; i++)
        {
            insert(root, words[i]);
        }
        
        String output = longest(root);
    }
    
    private String longest(TrieNode root)
    {
        TrieNode current = root;
        HashMap<Character, TrieNode> rootChilds = root.children;
        HashMap<Character, TrieNode> childs = current.children;
        //ArrayList<String> words = new ArrayList<String>();
        String longestWord = "";
        String currentWord = "";
        
        for (Map.Entry<Character, TrieNode> entry : rootChilds.entrySet())
        {
            currentWord = "";
            if (entry.getValue().isWord)
            {
                currentWord += entry.getKey();
                current = entry.getValue();
            }
            else
            {
                continue;
            }
            
            childs = current.children;
            
            
        }
        
        
    }
    
    private boolean greaterThan(String s, String t)
    {
        if (s.length() == t.length())
        {
            int comp = s.compareTo(t);
            
            if (comp == 1)
                return false;
            else
                return true;
        }
    
        return s.length() > t.length();
    }
    
    private void insert(TrieNode root, String word)
    {
        TrieNode current = root;
        
        for (int i = 0; i < word.length(); i++)
        {
            HashMap<Character, TrieNode> childs = current.children;
            
            char c = word.charAt(i);
            
            if (childs.containsKey(c))
            {
                current = childs.get(c);
            }
            else
            {
                TrieNode t = new TrieNode(c);
                childs.put(c, t);
                current = t;
            }
        }
        
        current.isWord = true;
    }
    
    
    
    
    
    
    
    
    
    
    
    
}