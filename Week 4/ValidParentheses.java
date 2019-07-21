class Solution {
    public boolean isValid(String s) {
        // 0 : '(' or ')'
        // 1 : '[' or ']'
        // 2 : '{' or '}'
        Stack<Integer> open = new Stack<Integer>();
        
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (c == '(')
                open.push(0);
            else if(c == '[')
                open.push(1);
            else if (c == '{')
                open.push(2);
            else if (c == ')')
            {
                if (!open.isEmpty() && open.peek() == 0)
                    open.pop();
                else
                    return false;
            }
            else if (c == ']')
            {
                if (!open.isEmpty() && open.peek() == 1)
                    open.pop();
                else
                    return false;
            }
            else
            {
                if (!open.isEmpty() && open.peek() == 2)
                    open.pop();
                else
                    return false;
            }
                
        }
        
        return open.isEmpty();
        
    }
}