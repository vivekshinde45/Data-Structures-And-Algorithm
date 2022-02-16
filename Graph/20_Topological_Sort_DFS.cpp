https://practice.geeksforgeeks.org/problems/topological-sort/1




class Solution
{
	public:
	//Function to return list containing vertices in Topological order.
	void dfs(vector<int> adj[], int src, vector<int> &ans, vector<bool> &vis){
	    vis[src] = true;
	    for(int nbr : adj[src]){
	        if(!vis[nbr]){
	            dfs(adj, nbr, ans, vis);
	        }
	    }
	    ans.push_back(src);
	}
	
	vector<int> topoSort(int V, vector<int> adj[]) {
	    // code here
	    vector<bool> vis(V, false);
	    vector<int> ans;
	    for(int i = 0; i < V; i++){
	        if(!vis[i]){
	            dfs(adj, i, ans, vis);
	        }
	    }
	    reverse(ans.begin(), ans.end());
	    return ans;
	}
	
};
