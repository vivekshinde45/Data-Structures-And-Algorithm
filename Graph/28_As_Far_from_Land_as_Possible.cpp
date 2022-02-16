https://leetcode.com/problems/as-far-from-land-as-possible/




class Solution {
public:
    int maxDistance(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        
        queue<int> q;
        vector<vector<bool>> vis(n, vector<bool>(m, false));
        vector<vector<int>> dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    vis[i][j] = true;
                    q.push(i * m + j);
                }
            }
        }
        if(q.size() == n * m){
            return -1;
        }
        
        int level = 0;
        while(q.size()){
            int size = q.size();
            while(size --> 0){
                auto rem = q.front();
                q.pop();
                int x = rem / m;
                int y = rem % m;
                
                if(vis[x][y] == true){
                    // continue;
                }
                
                for(auto const& d : dir){
                    int r = x + d[0];
                    int c = y + d[1];
                    
                    if(r >= 0 && r < n && c >= 0 && c < m && grid[r][c] == 0 && !vis[r][c]){
                        vis[r][c] = true;
                        q.push(r * m + c);
                    }
                }
            }
            level++;
        }
        return level - 1;
    }
};
