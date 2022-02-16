https://leetcode.com/problems/surrounded-regions/




class Solution {
public:
    void dfs(vector<vector<char>>& arr, int sr, int sc){
        int n = arr.size();
        int m = arr[0].size();
        vector<vector<int>> dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        arr[sr][sc] = '#';
        
        for(auto const& d : dir){
            int r = sr + d[0];
            int c = sc + d[1];
            
            if(r >= 0 && r < n && c >= 0 && c < m && arr[r][c] == 'O'){
                dfs(arr, r, c);
            }
        }
    }
    
    void solve(vector<vector<char>>& arr) {
        int n = arr.size();
        int m = arr[0].size();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 || i == n - 1 || j == 0 || j == m - 1){
                    if(arr[i][j] == 'O'){
                        dfs(arr, i, j);
                    }
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j] == '#'){
                    arr[i][j] = 'O';
                }
                else if(arr[i][j] == 'O'){
                    arr[i][j] = 'X';
                }
            }
        }
    }
};
