https://practice.geeksforgeeks.org/problems/minimum-swaps/1/#




class Solution{
    public:
    //Function to find the minimum number of swaps required to sort the array. 
    vector<int> par;
    
    int findPar(int u){
        return par[u] == u ? u : findPar(par[u]);
    }
    
	int minSwaps(vector<int>&nums){
	    // Code here
	    int n = nums.size();
	    par.resize(n , -1);
	    for(int i = 0; i < n; i++){
	        par[i] = i;
	    }
	    unordered_map<int, int> map;
	    for(int i = 0; i < n; i++){
	        map.insert({nums[i], i});
	    }
	    sort(nums.begin(), nums.end());
	    for(int i = 0; i < n; i++){
	        int u = map[nums[i]];
	        int v = i;
	        int p1 = findPar(u);
	        int p2 = findPar(v);
	        
	        if(p1 != p2){
	            par[p1] = p2;
	        }
	    }
	    int count = 0;
	    for(int i = 0; i < n; i++){
	        if(par[i] == i){
	            count++;
	        }
	    }
	    return n - count;
	}
};
