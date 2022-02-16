https://leetcode.com/problems/max-area-of-island/submissions/




class Solution {
public:
    vector<int> par;
    vector<int> size;
    
    int findParent(int a){
        if(par[a] == a)
            return a;
        
        return par[a] = findParent(par[a]);
    }
    
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        par.resize(n * m, -1);
        size.resize(n * m, 1);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    int idx = i * m + j;
                    par[idx] = idx;
                }
            }
        }
        
        vector<vector<int>> dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    int idx = i * m + j;
                    int p1 = findParent(idx);
                    
                    for(vector<int>& d : dir){
                        int r = i + d[0];
                        int c = j + d[1];
                        if(r >= 0 && r < n && c >= 0 && c < m && grid[r][c] == 1){
                            int jdx = r * m + c;
                            int p2 = findParent(jdx);
                            
                            if(p1 != p2){
                                par[p2] = p1;
                                size[p1] += size[p2];
                            }
                        }
                    }
                }
            }
        }
        int max_area = 0;
        for(int i = 0; i < n * m; i++){
            if(par[i] == i){
                max_area = max(max_area, size[i]);
            }
        }
        return max_area;
    }
};
