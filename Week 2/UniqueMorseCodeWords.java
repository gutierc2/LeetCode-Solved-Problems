class Solution {
    
    // Regarding the transformation of each word, I tried two different
    // approaches. First I thought to use the "+=" operator to concatenate
    // the strings together. However, I figured this might be too slow since
    // Strings in java are immutable. So using the operator might result
    // in a slower time complexity. I have not used StringBuilder much
    // but I figured since we care about time complexity, it was worth it
    // to look it up. Using StringBuilder over regular String concatentation
    // proved to in fact be a quicker approach.
    public int uniqueMorseRepresentations(String[] words) {
        HashSet<String> morseSet = new HashSet<String>(words.length, 1.1f);
        
        for (int i = 0; i < words.length; i++)
        {
            // We do not have to check if the item is already in the set
            // because the add method does this internally for us.
            morseSet.add(transformation(words[i]));
        }
        
        return morseSet.size();
    }
    
    private String transformation(String s)
    {
        String[] table = {".-","-...","-.-.","-..",".",
                          "..-.","--.","....","..",".---",
                          "-.-",".-..","--","-.","---",
                          ".--.","--.-",".-.","...","-",
                          "..-","...-",".--","-..-","-.--",
                          "--.."};
        
        StringBuilder morseCode = new StringBuilder(s.length()*4);
        
        //String morseCode = "";
        
        for (int i = 0; i < s.length(); i++)
        {
            int c = s.charAt(i) - 97;
            
            //morseCode += table[c];
            morseCode.append(table[c]);
        }
        
        //return morseCode;
        return morseCode.toString();
    }
}