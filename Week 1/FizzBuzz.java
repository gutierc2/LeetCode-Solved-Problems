class Solution {
    
    public List<String> fizzBuzz(int n) {
        List<String> output = new LinkedList<String>();
        
        for (int i = 1; i <= n; i++)
        {
            output.add(fizzBuzzOrNeither(i));
        }
        
        return output;
    }
    
    private String fizzBuzzOrNeither(int n)
    {
        String output = "";
        
        if (n % 3 == 0)
            output += "Fizz";
        
        if (n % 5 == 0)
            output += "Buzz";
        
        if (output.length() == 0)
            output += n;
        
        return output;
    }
}