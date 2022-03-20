https://leetcode.com/problems/island-perimeter/



// BY TRAVERSING ON MATRIX
class Solution {
public:
    int islandPerimeter(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        
        int ans = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    ans += 4;
                    
                    if(i > 0 && grid[i - 1][j] == 1){
                        ans -= 2;
                    }
                    if(j > 0 && grid[i][j - 1] == 1){
                        ans -= 2;
                    }
                }
            }
        }
        
        return ans;
    }
};


// BY USING THE DIRECTRION ARRAY
class Solution {
public:
    int islandPerimeter(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        int ans = 0;
        vector<vector<int>> dir = {{0, 1},{1, 0},{0, -1},{-1, 0}};
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    int nbrs = 0;
                    for(auto d : dir){
                        int r = i + d[0];
                        int c = j + d[1];
                        
                        if(r >= 0 && r < n && c >= 0 && c < m && grid[r][c] == 1){
                            nbrs++;
                        }
                    }
                    ans += (4 - nbrs);
                }
            }
        }
        return ans;
    }
};

// BY IMPLEMENTING THE BFS
class Solution {
public:
    int bfs(vector<vector<int>>& grid, int sr, int sc){
        int n = grid.size();
        int m = grid[0].size();
        vector<vector<int>> dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        
        queue<int> q;
        q.push(sr * m + sc);
        
        int ans = 0;
        int cnt = 0;
        while(q.size()){
            auto rem = q.front();
            q.pop();
            int i = rem / m;
            int j = rem % m;
            
            for(auto const& d : dir){
                int r = i + d[0];
                int c = j + d[1];
                
                if(r >= 0 && r < n && c >= 0 && c < m && grid[r][c] == 1){
                    cnt++;
                    // cout << cnt << endl;
                }
            }
        }
        ans = 4 - cnt;
        // cout << 4 << "-" << cnt << "=" << ans << endl;
        return ans;
    }
    
    
    int islandPerimeter(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    ans += bfs(grid, i, j);
                    // cout << "(" << i << ", " << j << ")" << ans << endl;
                }
            }
        }
        return ans;
    }
};
