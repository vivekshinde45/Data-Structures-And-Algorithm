https://leetcode.com/problems/is-graph-bipartite/




class Solution {
    class pair{
        int v;
        int level;
        pair(int v, int level){
            this.v = v;
            this.level = level;
        }
    }
    
    public boolean isBipartite_BFS(int[][] graph, int src, int[] vis){
        int n = graph.length;
        Queue<pair> q = new ArrayDeque<>();
        q.add(new pair(src, 0));
        
        while(q.size() > 0){
            pair rem = q.remove();
            
            int vtc = rem.v;
            int level = rem.level;
            
            if(vis[vtc] != -1){
                if(level != vis[vtc]){
                    return false;
                }
            }else{
                vis[vtc] = level;
            }
            
            for(int e : graph[vtc]){
                if(vis[e] == -1){
                    q.add(new pair(e, level + 1));
                }
            }
        }
        return true;
    }
    
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        Arrays.fill(vis, -1);
        
        for(int i = 0; i < n; i++){
            if(vis[i] == -1){
                boolean res = isBipartite_BFS(graph, i, vis);
                if(res == false){
                    return false;
                }
            }
        }
        return true;
    }
}
