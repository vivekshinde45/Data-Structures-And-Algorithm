https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1/#




class Solution {
    public static void findPath_Recursive(int[][] mat, int sr, int sc, int dr, int dc, List<String> list, String psf, int[][] dir, String[] dirS){
        if(sr == dr && sc == dc){
            list.add(psf);
            // System.out.println(psf);
            return;
        }
        mat[sr][sc] = 0;
        for(int d = 0; d < dir.length; d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            if(r >= 0 && r <= dr && c >= 0 && c <= dc && mat[r][c] == 1){
                findPath_Recursive(mat, r, c, dr, dc, list, psf + dirS[d], dir, dirS);
            }
        }
        mat[sr][sc] = 1;
    }
    
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> ans = new ArrayList<>();
        if(m[0][0] == 0 || m[n - 1][n - 1] == 0){
            return ans;
        }
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        String[] dirS = {"U", "D", "L", "R"};
        
        findPath_Recursive(m, 0, 0, n - 1, n - 1, ans, "", dir, dirS);
        return ans;
    }
}
