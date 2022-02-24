https://www.lintcode.com/problem/912/




public class Solution {
    /**
     * @param grid: a 2D grid
     * @return: the minimize travel distance
     */
    public int minTotalDistance(int[][] grid) {
        // Write your code here
        int n = grid.length;
        int m = grid[0].length;
        ArrayList<Integer> xCo = new ArrayList<>();  //for storing X - Coordinates
        ArrayList<Integer> yCo = new ArrayList<>();  //for storing Y - Coordinates

        // traversing ROW wise for storing the X - Coordinates in sorted Order
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    xCo.add(i);
                }
            }
        }
        // traversing COL wise for storing the Y - Coordinates in sorted Order
        for(int j = 0; j < m; j++){
            for(int i = 0; i < n; i++){
                if(grid[i][j] == 1){
                    yCo.add(j);
                }
            }
        }
        int len = xCo.size() / 2; // calculate the median pt
        int x2 = xCo.get(len);
        int y2 = yCo.get(len);

        int ans = 0;
        
        // calculating the (Manhattan Distance from every 1 to that median Coordinates (x2, y2))
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    ans += (Math.abs(i - x2) + Math.abs(j - y2));
                }
            }
        }
        return ans;
    }
}
