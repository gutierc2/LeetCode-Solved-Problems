class Solution {
    
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> row = new HashSet<Character>();
        HashSet<Character> column = new HashSet<Character>();
        HashSet<Character> subbox = new HashSet<Character>();
        
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                if (board[i][j] != '.')
                {
                    if(row.contains(board[i][j]))
                        return false;
                    else
                        row.add(board[i][j]);
                }
                
                if(board[j][i] != '.')
                {
                    if(column.contains(board[j][i]))
                        return false;
                    else
                        column.add(board[j][i]);
                }
                
                
            }
            
            row.clear();
            column.clear();
        }
        
        for(int i = 0; i < 7; i += 3)
        {
            for(int j = 0; j < 7; j += 3)
            {
                for(int k = 0; k < 3; k++)
                {
                    for(int l = 0; l < 3; l++)
                    {
                        if (board[k+i][l+j] != '.')
                        {
                            if(subbox.contains(board[k+i][l+j]))
                                return false;
                            else
                                subbox.add(board[k+i][l+j]);
                        }
                            
                    }
                }
                subbox.clear();
            }
        }
        
        return true;
    }
}