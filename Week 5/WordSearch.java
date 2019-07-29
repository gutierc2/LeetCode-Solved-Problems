class Solution {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 && !word.equals(""))
            return false;
        
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                if (existHelper(board, word, i, j))
                    return true;
            }
        }
        
        return false;
    }
    
    private boolean existHelper(char[][] board, String word, int vr, int vc)
    {
        if (word.equals(""))
            return true;
        
        if (vr < 0 || vr >= board.length)
            return false;
        
        if (vc < 0 || vc >= board[vr].length)
            return false;
        
        int top = vr-1;
        int bot = vr+1;
        int left = vc-1;
        int right = vc+1;
        
        char c = board[vr][vc];
        
        if (c == word.charAt(0))
        {
            board[vr][vc] = '.';
            String rest = word.substring(1);
            
            if (existHelper(board, rest, top, vc))
                return true;
            
            if(existHelper(board, rest, bot, vc))
                return true;
            
            if (existHelper(board, rest, vr, left))
                return true;
            
            if (existHelper(board, rest, vr, right))
                return true;
            
            board[vr][vc] = c;
        }
        
        return false;
    }
}