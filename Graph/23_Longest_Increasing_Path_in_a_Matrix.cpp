https://leetcode.com/problems/longest-increasing-path-in-a-matrix/




class Solution {
public:
    void print2D(vector<vector<int>>& inDegree){
        int n = inDegree.size();
        int m = inDegree[0].size();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                cout << inDegree[i][j] << " ";
            }
            cout << endl;
        }
    }
    
    int longestIncreasingPath(vector<vector<int>>& matrix) {
        int n = matrix.size();
        int m = matrix[0].size();
        
        vector<vector<int>> inDegree(n, vector<int>(m));
        vector<vector<int>> dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(vector<int> d : dir){
                    int x = i + d[0];
                    int y = j + d[1];
                    
                    if(x >= 0 && x < n && y >= 0 && y < m && matrix[i][j] < matrix[x][y]){
                        inDegree[x][y]++;
                    }
                }
            }
        }
        // print2D(inDegree);
        
        queue<int> q;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(inDegree[i][j] == 0){
                    q.push(i * m + j);
                }
            }
        }
        
        // int val = (2 * m + 1);
        // cout << (2 * m + 1) << endl;
        // cout << "r" << "= " << (val / m) << "c" << "= " << (val % m) << endl;
        
        int level = 0;
        while(q.size()){
            int size = q.size();
            while(size --> 0){
                auto rem = q.front();
                q.pop();
                
                int x = rem / m;
                int y = rem % m;
                
                for(auto const & d : dir){
                    int r = x + d[0];
                    int c = y + d[1];
                    
                    if(r >= 0 && r < n && c >= 0 && c < m && matrix[x][y] < matrix[r][c]){
                        inDegree[r][c]--;
                        if(inDegree[r][c] == 0){
                            q.push(r * m + c);
                        }
                    }
                }
            }
            level++;
        }
        return level;
    }
};
