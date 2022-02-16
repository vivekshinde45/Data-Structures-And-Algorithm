https://leetcode.com/problems/rotting-oranges/




class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        
        queue<int> q;
        vector<vector<bool>> vis(n, vector<bool>(m, false));
        vector<vector<int>> dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    q.push(i * m + j);
                }
                else if(grid[i][j] == 1){
                    count++;
                }
            }
        }
        
        if(count == 0){
            return 0;
        }
        
        int cnt = 0;
        int level = 0;
        while(q.size()){
            int size = q.size();
            while(size --> 0){
                auto rem = q.front();
                q.pop();
                
                int x = rem / m;
                int y = rem % m;
                
                for(auto const& d : dir){
                    int r = x + d[0];
                    int c = y + d[1];
                    
                    if(r >= 0 && r < n && c >= 0 && c < m && !vis[r][c] && grid[r][c] == 1){
                        cnt++;
                        vis[r][c] = true;
                        q.push(r * m + c);
                    }
                }
            }
            level++;
        }
        return count == cnt ? level - 1 : -1;
    }
};
