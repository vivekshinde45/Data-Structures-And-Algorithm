https://leetcode.com/problems/course-schedule-ii/




class Solution {
public:
    vector<int> findOrder(int n, vector<vector<int>>& prerequisites) {
        vector<int> inDegree(n, 0);
        vector<vector<int>> graph(n);
        
        vector<int> ans;
        
        for(auto const& e : prerequisites){
            int u = e[0];
            int v = e[1];
            inDegree[v]++;
            graph[u].push_back(v);
        }
        
        queue<int> q;
        for(int i = 0; i < n; i++){
            if(inDegree[i] == 0){
                q.push(i);
            }
        }
        
        while(q.size()){
            // remove
            auto rem = q.front();
            q.pop();
            
            // work
            ans.push_back(rem);
            
            // add
            for(auto const& val : graph[rem]){
                inDegree[val]--;
                if(inDegree[val] == 0){
                    q.push(val);
                }
            }
        }
        reverse(ans.begin(), ans.end());
        if(ans.size() != graph.size()){
            return {};
        }else{
            return ans;
        }
    }
};
