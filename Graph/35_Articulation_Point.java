======================================= BRUTE FORCE ======================================= 
Time -> 0(V * 0(V + E))
      where V = # of VTCS
            E = # of Edges
Space -> 0(V)
  
import java.util.*;
import java.io.*;


public class Main{
    public static void getConnectedComponents(ArrayList<Integer>[] graph, int src, boolean[] vis){
        vis[src] = true;
        for(Integer nbr : graph[src]){
            if(!vis[nbr])
                getConnectedComponents(graph, nbr, vis);
        }
    }
    
    // remove VTX from a given graph
    public static void removeVtx(ArrayList<Integer>[] graph, int src, int oSRC){
        ArrayList<Integer> nbrs = graph[src];
        for(int i = 0; i < nbrs.size(); i++){
            ArrayList<Integer> nbrsAdjList = graph[nbrs.get(i)];
            for(int j = nbrsAdjList.size() - 1; j >= 0; j--){
                if(nbrsAdjList.get(j) == oSRC){
                    nbrsAdjList.remove(new Integer(oSRC));
                }
            }
        }
        for(int i = nbrs.size() - 1; i >= 0; i--){
            nbrs.remove(new Integer(nbrs.get(i)));
        }
        // printGraph(graph);
    }
    
    // copy of graph
    public static ArrayList<Integer>[] copyOfGraph(ArrayList<Integer>[] graph){
        ArrayList<Integer>[] nGraph = new ArrayList[graph.length];
        for(int i = 0; i < graph.length; i++)nGraph[i] = new ArrayList<>();
        
        for(int i = 0; i < graph.length; i++){
            ArrayList<Integer> nbrs = graph[i];
            nGraph[i] = (ArrayList)nbrs.clone();
        }
        return nGraph;
    }
    
    //printGraph
    public static void printGraph(ArrayList<Integer>[] graph){
        for(int i = 0; i < graph.length; i++){
            System.out.print(i + " ");
            System.out.print(graph[i]);
        }
        System.out.println();
    }
    
    public static void articulationPoint(ArrayList<Integer>[] graph, int V, int E){
        /*
            1. Get the connected component of the given graph
            2. i = 0 to i < V try an delete ith vtx from graph
            3. After removing that i'th VTX again get the connected components if it is more than the prev one
            4. Then we got one VTX that is an articulation point of graph
            5. do this for every VTX
        */
        boolean[] vis = new boolean[V];
        ArrayList<Integer> articulation = new ArrayList<>();
        
        int gcc = 0;
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                getConnectedComponents(graph, i, vis);
                gcc++;
            }
        }
        System.out.println(gcc);
        
        for(int i = 0; i < V; i++){
            ArrayList<Integer>[] copy = copyOfGraph(graph);
            // printGraph(copy);
            removeVtx(copy, i, i);
            // System.out.println(i + "   ===================================");
            
            int gccForRemovedVTX = 0;
            Arrays.fill(vis, false);
            for(int j = 0; j < V; j++){
                if(!vis[j]){
                    getConnectedComponents(copy, j, vis);
                    gccForRemovedVTX++;
                }
            }
            System.out.println(gccForRemovedVTX);
            if(gccForRemovedVTX - 1 > gcc){
                articulation.add(i);
            }
            for(int j = 0; j < graph.length; j++)copy[j] = new ArrayList<>();
        }
        System.out.println(articulation);
    }
    
    public static void main(String[] args){
        ArrayList<Integer>[] graph = new ArrayList[5];
        for(int i = 0; i < 5; i++)graph[i] = new ArrayList<>();
        int V = 5;
        int E = 5;
        
        graph[0].add(1);
		graph[1].add(0);
		
		graph[0].add(2);
		graph[2].add(0);
		
		graph[1].add(2);
		graph[2].add(1);
		
		graph[1].add(3);
		graph[3].add(1);
		
		graph[3].add(4);
		graph[4].add(3);
		
        articulationPoint(graph, V, E);
    }
}


=========================================================== OPTIMIZED =========================================================== 
Time -> 0(V + E)
Space -> 0(V)
import java.util.*; 

class Main
{

	private void dfs(int node, int parent, int vis[], int tin[], int low[], ArrayList<ArrayList<Integer>> adj, int timer, int isArticulation[]) {
		vis[node] = 1; 
		tin[node] = low[node] = timer++; 
		int child = 0; 
		for(Integer it: adj.get(node)) {
			if(it == parent) continue; 

			if(vis[it] == 0) {
				dfs(it, node, vis, tin, low, adj, timer, isArticulation); 
				low[node] = Math.min(low[node], low[it]); 

				if(low[it] >= tin[node] && parent != -1) {
					isArticulation[node] = 1;  
				}
				child++; 
			} else {
				low[node] = Math.min(low[node], tin[it]); 
			}
		}
		if(parent != -1 && child > 1) isArticulation[node] = 1;  
	}
    void printBridges(ArrayList<ArrayList<Integer>> adj, int n)
    {
        int vis[] = new int[n]; 
        int tin[] = new int[n];
        int low[] = new int[n]; 
        
        int isArticulation[] = new int[n];

        int timer = 0; 
        for(int i = 0;i<n;i++) {
        	if(vis[i] == 0) {
        		dfs(i, -1, vis, tin, low, adj, timer, isArticulation); 
        	}
        }
        
        for(int i = 0;i<n;i++) {
            if(isArticulation[i] == 1) System.out.println(i); 
        }
    }
    public static void main(String args[])
    {
        int n = 5;
        ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer> >();
		
		for (int i = 0; i < n; i++) 
			adj.add(new ArrayList<Integer>());
			
		adj.get(0).add(1);
		adj.get(1).add(0);

		adj.get(0).add(2);
		adj.get(2).add(0);

		adj.get(1).add(2);
		adj.get(2).add(1);

		adj.get(1).add(3);
		adj.get(3).add(1);

		adj.get(3).add(4);
		adj.get(4).add(3);
			
		Main obj = new Main(); 
		obj.printBridges(adj, n); 
		
    }
}
