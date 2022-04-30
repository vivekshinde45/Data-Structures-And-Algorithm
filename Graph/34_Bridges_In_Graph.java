------------------------------------------------ BRUTE FORCE ------------------------------------------------
Time -> 0(E * 0(V + E))
        where E = # of Edges
              V = # of vtcs
Space -> 0(V)
  
import java.util.*;

public class Solution {
	
	public static boolean isBridge(List<Integer>[] graph, boolean[] vis, int currentVtcs, int v, int u){
		// we are mainly focus on how we can return false from here
		vis[currentVtcs] = true;
		for(Integer nbr : graph[currentVtcs]){
			if(vis[nbr] || (nbr == v && u == currentVtcs)){
				continue;
			}
			else{
				if(nbr == v){
					return false;
				}
				if(!isBridge(graph, vis, nbr, v, u)){
					return false;
				}
			}
		}
		return true;
	}

    public static List<List<Integer>> findBridges(int[][] edges, int V, int E) {

        // Write your code here!
		List<Integer>[] graph = new ArrayList[V];
		for(int i = 0; i < V; i++){
			graph[i] = new ArrayList<>();
		}
		for(int[] e : edges){
			int u = e[0];
			int v = e[1];
			graph[u].add(v);
			graph[v].add(u);
		}
		List<List<Integer>> allBridges = new ArrayList<>();
		boolean[] vis = new boolean[V];
		for(int[] e : edges){
			int u = e[0];
			int v = e[1];
			Arrays.fill(vis, false);
			if(isBridge(graph, vis, u, v, u)){
				List<Integer> bridge = new ArrayList<>(Arrays.asList(u, v));
				allBridges.add(bridge);
			}
		}
		return allBridges;

    }
}

------------------------------------------------------------------------------------------------------------------------------------------------------------
  
------------------------------------------------ OPTIMIZED ------------------------------------------------
Time -> 0(V + E)
Space -> 0(V)
  
import java.util.*;

public class Solution {
	
	public static void dfs(int currentVtcs, int par, int timer, int[] low, int[] tin, boolean[] vis, List<Integer>[] graph, List<List<Integer>> allBridges){
		tin[currentVtcs] = timer;
		low[currentVtcs] = timer;
		timer++;
		
		vis[currentVtcs] = true;
		for(Integer nbr : graph[currentVtcs]){
			if(!vis[nbr]){
				dfs(nbr, currentVtcs, timer, low, tin, vis, graph, allBridges);
				
				low[currentVtcs] = Math.min(low[nbr], low[currentVtcs]);
				
				if(low[nbr] > tin[currentVtcs]){
					allBridges.add(new ArrayList<>(Arrays.asList(currentVtcs, nbr)));
				}
			}
			else if (nbr != par){
				low[currentVtcs] = Math.min(low[currentVtcs], tin[nbr]);
			}
		}
	}

    public static List<List<Integer>> findBridges(int[][] edges, int V, int E) {

        // Write your code here!
		List<Integer>[] graph = new ArrayList[V];
		for(int i = 0; i < V; i++)	graph[i] = new ArrayList<>();
		for(int[] e : edges){
			int u = e[0];
			int v = e[1];
			graph[u].add(v);
			graph[v].add(u);
		}
		boolean[] vis = new boolean[V];
		int[] low = new int[V];
		int[] tin = new int[V];
		
		int timer = 0;
		List<List<Integer>> allBridges = new ArrayList<>();
		
		for(int i = 0; i < V; i++){
			if(!vis[i])
				dfs(i, -1, timer, low, tin, vis, graph, allBridges);
		}
		return allBridges;
    }
}
