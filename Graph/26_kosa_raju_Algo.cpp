https://practice.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1/




class Solution{
	public:
	
	void dfs(vector<int> adj[], int src, stack<int>& st, vector<bool>& vis){
	    vis[src] = true;
	    for(auto const e : adj[src]){
	        if(!vis[e]){
	            dfs(adj, e, st, vis);
	        }
	    }
	    st.push(src);
	}
	
	void dfs2(vector<int> adj[], int src, vector<bool>& vis, vector<int>& ans){
	    vis[src] = true;
	    ans.push_back(src);
	    for(auto const& e : adj[src]){
	        if(!vis[e]){
	            dfs2(adj, e, vis, ans);
	        }
	    }
	}
	
	//Function to find number of strongly connected components in the graph.
    int kosaraju(int V, vector<int> adj[]){
        //code here
        stack<int> st;
        vector<bool> vis(V, false);
        
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                dfs(adj, i, st, vis);
            }
        }
        vis.resize(V, false);
         vector<int> trans[V];
       for(int i = 0; i<V; i++){
           vis[i] = false;
           for(auto x : adj[i]){
               trans[x].push_back(i);
           }
       }
        
        vector<vector<int>> ans;
        
        int count = 0;
        while(st.size()){
            int rem = st.top();
            st.pop();
            vector<int> v;
            if(!vis[rem]){
                dfs2(trans, rem, vis, v);
                count++;
            }
            ans.push_back(v);
        }
        
        for(int i = 0; i < ans.size(); i++){
            int size = ans[i].size();
            for(int j = 0; j < size; j++){
                cout << ans[i][j] << " " ;
            }
            cout << endl;
        }
        
        return count;
    }
};
