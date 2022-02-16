https://leetcode.com/problems/find-eventual-safe-states/




class Solution {
public:
    bool isCycle(vector<vector<int>>& graph, int src, vector<int>& vis){
        bool cycle = false;
        
        vis[src] = 1;
        for(auto const& e : graph[src]){
            if(vis[e] == 0){
                cycle = cycle || isCycle(graph, e, vis);
            }
            else if(vis[e] == 1){
                return true;
            }
        }
        if(cycle){
            return true;
        }
        vis[src] = 2;
        return cycle;
    }
    
    vector<int> eventualSafeNodes(vector<vector<int>>& graph) {
        int n = graph.size();
        vector<int> ans;
        vector<int> vis(n, 0);
        
        for(int i = 0; i < n; i++){
            if(vis[i] == 0){
                bool cycle = isCycle(graph, i, vis);
            }
            if(vis[i] == 2){
                ans.push_back(i);
            }
        }
        return ans;
    }
};
