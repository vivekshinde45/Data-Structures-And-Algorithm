https://leetcode.com/problems/max-area-of-island/submissions/



class Solution {
public:
    int maxAreaOfIsland (vector<vector<int>>& grid, int i, int j, vector<vector<int>>& dir){
        int n = grid.size();
        int m = grid[0].size();
        
        int ans = 0;
        queue<int> q;
        q.push(i * m + j);
        
        while(q.size() > 0){
            auto pt = q.front();
            q.pop();
            
            ans++;
            
            int x = pt / m;
            int y = pt % m;
            
            for(auto const& d : dir){
                int r = x + d[0];
                int c = y + d[1];
                
                if(r >= 0 && r < n && c >= 0 && c < m && grid[r][c] == 1){
                    grid[r][c] = 0;
                    q.push(r * m + c);
                }
            }
        }
        return ans;
    }
    
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        
        if(n == 1 && m == 1){
            if(grid[0][0] == 1){
                return 1;
            }
        }
        
        int ans = 0;
        
        queue<int> q;
        vector<vector<int>> dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    grid[i][j] = 0;
                    ans = max(ans, maxAreaOfIsland(grid, i, j, dir));
                }
            }
        }
        return ans;
    }
};
