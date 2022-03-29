https://leetcode.com/problems/unique-paths-ii/



TLE====================================================
class Solution {
    public int uniquePathsWithObstacles_Recursive(int[][] mat, int sr, int sc, int dr, int dc, int[][] dir){
        if(sr == dr && sc == dc){
            return 1;
        }
        int count = 0;
        for(int[] d : dir){
            int r = sr + d[0];
            int c = sc + d[1];
            if(r >= 0 && r <= dr && c >= 0 && c <= dc && mat[r][c] != 1){
                count += uniquePathsWithObstacles_Recursive(mat, r, c, dr, dc, dir);
            }
        }
        return count;
    }
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dir = {{0, 1}, {1, 0}};
        return uniquePathsWithObstacles_Recursive(obstacleGrid, 0, 0, n - 1, m - 1, dir);
    }
}
