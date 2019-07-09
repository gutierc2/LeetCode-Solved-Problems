class Solution {
    
    // Toughest part of this solution was figuring out
    // the parser logic through trial and error.
    // I went with a recursive approach, so it used
    // more memory than other solutions.
    
    // At first I used a HashMap for this problem
    // and then created a tree map from it to create
    // the output, but then I realized I could just
    // use a tree map from the beginning instead.
    private TreeMap<String, Integer> eleMap;
    
    public String countOfAtoms(String formula) {
        eleMap = new TreeMap<String, Integer>();
        
        parse(formula, 1);
        
        //TreeMap<String, Integer> eleSorted = new TreeMap<String, Integer>(eleMap);

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Integer> entry : eleMap.entrySet())
        {
            sb.append(entry.getKey());
            int num = entry.getValue();
            
            if (num > 1)
                sb.append(num);
        }
        
        return sb.toString();
    }
    
    private void parse(String formula, int multiplier)
    {
        if (formula.length() == 0)
            return;
        
        if (formula.charAt(0) == '(')
        {
            int numOpenParen = 1;
            int numCloseParen = 0;
            int i;
            
            for(i = 1; i < formula.length() && numOpenParen != numCloseParen; i++)
            {
                if (formula.charAt(i) == '(')
                {
                    numOpenParen++;
                }
                else if(formula.charAt(i) == ')')
                {
                    numCloseParen++;
                }
            }
            int endIndex = i-1;
            StringBuilder sb = new StringBuilder();
            sb.append(formula.charAt(i));
            i++;
            while (i < formula.length() 
              && Character.isDigit(formula.charAt(i)))
            {
                sb.append(formula.charAt(i));
                i++;
            }

            int count = Integer.parseInt(sb.toString());
            
            parse(formula.substring(1, endIndex), count*multiplier);
            parse(formula.substring(i,formula.length()), multiplier);
        }
        else
        {   // at this point we know for sure we have an uppercase letter
            if (formula.length() > 1)
            {   // is the next character also a letter?
                if (Character.isLetter(formula.charAt(1)))
                {   // is it lower case?
                    if(Character.isLowerCase(formula.charAt(1)))
                    {   // from here we are building the string that
                        // will become the element abbreviation
                        StringBuilder sb = new StringBuilder();
                        sb.append(formula.charAt(0));
                        int i = 1;
                        while (i < formula.length() 
                          && Character.isLowerCase(formula.charAt(i)))
                        {
                            sb.append(formula.charAt(i));
                            i++;
                        }
                        
                        String element = sb.toString();
                        // is the next character a digit or another character?
                        if(i < formula.length() && Character.isDigit(formula.charAt(i)))
                        {
                            // It is a digit at this point so we get all the digits
                            // that make up the count and convert them to integer
                            sb = new StringBuilder();
                            sb.append(formula.charAt(i));
                            i++;
                            while (i < formula.length() 
                              && Character.isDigit(formula.charAt(i)))
                            {
                                sb.append(formula.charAt(i));
                                i++;
                            }
                            
                            int count = Integer.parseInt(sb.toString());
                            conditionalPut(element, count*multiplier);
                            // maybe put multiplier here instead of 1?
                            parse(formula.substring(i, formula.length()), multiplier);
                        }
                        else
                        {   // The next character is not a digit,
                            // therefore it is another uppercase letter
                            conditionalPut(element, multiplier); // 1* multiplier = multiplier
                            parse(formula.substring(i, formula.length()), multiplier);
                        }
                    }
                    else // We have an uppercase letter by itself
                    {
                        conditionalPut(Character.toString(formula.charAt(0)), multiplier);
                        parse(formula.substring(1,formula.length()), multiplier);
                    }
                }
                else if(formula.charAt(1) == '(')
                {
                    conditionalPut(Character.toString(formula.charAt(0)), multiplier);
                    parse(formula.substring(1,formula.length()), multiplier);
                }
                else // the letter after the upper case letter is a digit
                {
                    int i = 1;
                    StringBuilder sb = new StringBuilder();
                    sb.append(formula.charAt(i));
                    i++;
                    while (i < formula.length() 
                      && Character.isDigit(formula.charAt(i)))
                    {
                        sb.append(formula.charAt(i));
                        i++;
                    }

                    int count = Integer.parseInt(sb.toString());
                    conditionalPut(Character.toString(formula.charAt(0)), count*multiplier);
                    parse(formula.substring(i, formula.length()), multiplier);
                }
            }
            else // We have an uppercase letter by itself at the end of string
            {
                String element = "" + formula.charAt(0);
                
                conditionalPut(element, multiplier);
            }
        }
    }
    
    private void conditionalPut(String element, int value)
    {
        if (eleMap.containsKey(element))
        {
            eleMap.put(element, eleMap.get(element)+value);
        }
        else
        {
            eleMap.put(element, value);
        }
    }
}