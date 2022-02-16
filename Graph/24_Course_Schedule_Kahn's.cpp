https://leetcode.com/problems/course-schedule/



class Solution {
public:
    bool canFinish(int n, vector<vector<int>>& prerequisites) {
        vector<int> inDegree(n, 0);
        vector<vector<int>> graph(n);
        
        for(auto const& e : prerequisites){
            int u = e[0];
            int v = e[1];
            inDegree[v]++;
            graph[u].push_back(v);
        }
        
        int c = 0;
        
        queue<int> q;
        for(int i = 0; i < n; i++){
            if(inDegree[i] == 0){
                q.push(i);
            }
        }
        
        while(q.size()){
            auto rem = q.front();
            q.pop();
            
            c++;
            for(auto const& val : graph[rem]){
                inDegree[val]--;
                if(inDegree[val] == 0){
                    q.push(val);
                }
            }
        }
        
        return n == c;
    }
};
