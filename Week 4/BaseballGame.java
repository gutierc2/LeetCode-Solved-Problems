class Solution {
    public int calPoints(String[] ops) {
        
        
        Stack<Integer> scores = new Stack<Integer>();
        int totalPoints = 0;
        
        for(String s : ops)
        {
            if (Character.isDigit(s.charAt(0)) || s.charAt(0) == '-')
            {
                int roundScore = Integer.parseInt(s);
                scores.push(roundScore);
            }
            else if (s.charAt(0) == '+')
            {
                int score1 = scores.pop();
                int score2 = scores.pop();
                int roundScore = score1+score2;
                scores.push(score2);
                scores.push(score1);
                scores.push(roundScore);
                
            }
            else if (s.charAt(0) == 'D')
            {
                scores.push(scores.peek()*2);
            }
            else
            {
                scores.pop();
            }
        }
        
        while(!scores.isEmpty())
        {
            totalPoints += scores.pop();
        }
        
        return totalPoints;
    }
}