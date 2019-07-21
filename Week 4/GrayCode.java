class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> code = new ArrayList<Integer>();
        code.add(0);
        grayCode(code, n);
        
        return code;
    }
    
    private void grayCode(List<Integer> code, int n)
    {
        int p = (int) Math.pow(2, n);
        for(int i = 1; code.size() < p; i *= 2)
        {
            int s = code.size()-1;
            for(int j = s; j >= 0; j--)
            {
                code.add(code.get(j) + i);
            }
        }
    }
}