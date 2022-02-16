https://leetcode.com/problems/is-graph-bipartite/



class Solution {
public:
    bool isBipartite_bfs(vector<vector<int>>& graph, int src, vector<int>& vis){
        queue<pair<int, int>> q;
        q.push({src, 0});
        
        while(q.size()){
            auto rem = q.front();
            q.pop();
            int vtc = rem.first;
            int level = rem.second;
            
            if(vis[vtc] != -1){
                if(level != vis[vtc]){
                    return false;
                }
            }else{
                vis[vtc] = level;
            }
            
            for(auto const& e : graph[vtc]){
                if(vis[e] == -1){
                    q.push({e, level + 1});
                }
            }
        }
        return true;
    }
    
    bool isBipartite(vector<vector<int>>& graph) {
        int n = graph.size();
        vector<int> vis(n, -1);
        for(int i = 0; i < n; i++){
            if(vis[i] == -1){
                bool ans = isBipartite_bfs(graph, i, vis);
                if(ans == 0){
                    return false;
                }
            }
        }
        return true;
    }
};
