https://leetcode.com/problems/unique-paths/



TLE============================================
class Solution {
    public int uniquePaths_Recursive(int sr, int sc, int dr, int dc, int[][] dir){ 
        if(sr == dr && sc == dc){
            return 1;
        }
        int count = 0;
        for(int[] d : dir){
            int r = sr + d[0];
            int c = sc + d[1];
            if(r >= 0 && r <= dr && c >= 0 && c <= dc){
                count += uniquePaths_Recursive(r, c, dr, dc, dir);
            }
        }
        return count;
    }
    
    public int uniquePaths(int n, int m) {
        int[][] dir = {{0, 1}, {1, 0}};
        return uniquePaths_Recursive(0, 0, n - 1, m - 1, dir);
    }
}
