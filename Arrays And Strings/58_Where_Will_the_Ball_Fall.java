https://leetcode.com/problems/where-will-the-ball-fall/




class Solution {
    public int[] findBall(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] ans = new int[m];
        
        for(int j = 0; j < m; j++){
            int cPos = j;
            int nPos = -1;
            
            for(int i = 0; i < n; i++){
                nPos = cPos + grid[i][cPos];
                
                if(nPos < 0 || nPos >= m || grid[i][cPos] != grid[i][nPos]){
                    cPos = -1;
                    break;
                }
                cPos = nPos;
            }
            ans[j] = cPos;
        }
        return ans;
    }
}
