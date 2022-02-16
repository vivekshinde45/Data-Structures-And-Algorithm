class Solution{
	public:
	//Function to return list containing vertices in Topological order. 
	vector<int> topoSort(int V, vector<int> graph[]){
	    // code here
	    vector<int> indegree(V, 0);
	    vector<int> ans;
	    
	    for(int i = 0; i < V; i++){
	        for(auto const & e : graph[i]){
	            indegree[e]++;
	        }
	    }
	    queue<int> q;
	    for(int i = 0; i < V; i++){
	        if(indegree[i] == 0){
	            q.push(i);
	        }
	    }
	    
	    while(q.size()){
	        auto rem = q.front();
	        q.pop();
	        
	        ans.push_back(rem);
	        
	        for(auto const & e : graph[rem]){
	            indegree[e]--;
	            if(indegree[e] == 0){
	                q.push(e);
	            }
	        }
	    }
	    if(ans.size() == V){
	        return ans;
	    }else{
	        return {-1};
	    }
	}
};
