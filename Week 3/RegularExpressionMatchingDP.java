class Solution {
    
    // This was a very challenging problem for me, unfortunately
    // I caved and looked at the discussions on the problem.
    // I also checked out an explanation of the problem at:
    // https://www.youtube.com/watch?v=l3hda49XcDE&index=17&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr
    
    // However I made sure to not move on from the problem until
    // I fully understood the algorithm. I'm going to try to
    // figure out the other DP solutions on my own.
    public boolean isMatch(String s, String p) {
        
        int sLen = s.length();
        int pLen = p.length();
        
        boolean[][] dp = new boolean[sLen+1][pLen+1];
        
        dp[0][0] = true;
        
        for (int i = 2; i < pLen+1; i += 2)
        {
            if (p.charAt(i-1) == '*')
                dp[0][i] = dp[0][i-2];
        }
        
        
        for(int i = 1; i < sLen+1; i++)
        {
            for (int j = 1; j < pLen+1; j++)
            {
                char sChar = s.charAt(i-1);
                char pChar = p.charAt(j-1);
                
                if (sChar == pChar || pChar == '.')
                    dp[i][j] = dp[i-1][j-1];
                else if(pChar == '*')
                {
                    char pCharPrev = p.charAt(j-2);
                    if (pCharPrev != '.' && pCharPrev != sChar)
                        dp[i][j] = dp[i][j-2];
                    else if(pCharPrev == '.' || pCharPrev == sChar)
                        dp[i][j] = (dp[i][j-2] || dp[i-1][j-2] || dp[i-1][j]);
                }
            }
        }
        
        return dp[sLen][pLen];
        
    }
}