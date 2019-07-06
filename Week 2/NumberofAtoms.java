class Solution {
    
    // **** NOT DONE ****
    // Still working on the parser...
    private HashMap<String, Integer> eleMap;
    
    public String countOfAtoms(String formula) {
        eleMap = new HashMap<String, Integer>();
    }
    
    private void parse(String formula, int multiplier)
    {
        if (formula.charAt(0) == '(')
        {
            int numOpenParen = 1;
            int numCloseParen = 0;
            int i;
            
            for(i = 1; i < formula.length(); i++)
            {
                if(numOpenParen == numCloseParen)
                {
                    break;
                }
                else if (formula.charAt(i) == '(')
                {
                    numOpenParen++;
                }
                else if(formula.charAt(i) == ')')
                {
                    numClosedParen++;
                }
            }
            
            parse(formula.substring(0, i-1), Character.getNumericValue(formula.charAt(i)));
        }
        else
        {
            if (formula.length() > 1)
            {
                if (Character.isLetter(formula.charAt(1)))
                {
                    if(Character.isLowerCase(formula.charAt(1)))
                    {
                        StringBuilder sb = new StringBuilder();
                        sb.append(formula.getChar(0));
                        int i = 1;
                        while (i < formula.length() 
                          && Character.isLowerCase(formula.charAt(i)))
                        {
                            sb.append(formula.charAt(i));
                            i++;
                        }
                        
                        String element = sb.toString();
                        
                        if(Character.isDigit(formula.charAt(i)))
                        {
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
                            eleMap.put(element, count*multiplier);
                            parse(formula.substring(i, formula.length()), 1);
                        }
                        else
                        {
                            
                        }
                    }
                    else // We have an uppercase letter by itself
                    {
                        eleMap.put(formula.charAt(0).toString(), 1*multiplier);
                        parse(formula.substring(1,formula.length()), 1);
                    }
                }
                else
                {
                    
                }
            }
            else
            {
                
            }
        }
        
        
        /*
        for(int i = 0; i < formula.length(); i++)
        {
            char c = formula.charAt(i);
            if (Character.isLetter(c))
            {
                if (Character.isUpperCase(c))
                {
                    StringBuilder sb = new StringBuilder();
                    sb.append(c);
                    i++;
                    while(i < formula.length() 
                          && Character.isLowerCase(formula.charAt(i)))
                    {
                        sb.append(formula.charAt(i));
                        i++;
                    }
                    
                }
            }
            else if(Character.isDigit(c))
            {
                
            }
            else
            {
                
            }
        }
        */
    }
    
    private boolean doesNotContainParen(String formula)
    {
        for (int i = 0; < char.length)
    }
}