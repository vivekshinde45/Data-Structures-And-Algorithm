import java.util.*;

public class Main{
     public static class Edge{
        int u;
        int v;
        int wt;
        Edge(int u, int v, int wt){
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }

    public static class pair implements Comparable<pair>{
        int par;
        int src;
        int wt;
        pair(int par, int src, int wt){
            this.par = par;
            this.src = src;
            this.wt = wt;
        }
        public int compareTo(pair o){
            return this.wt - o.wt;
        }
    }

    public static void printDist(int[] dist){
        for(int val : dist){
            System.out.print(val + " ");
        }
        System.out.println();
    }
    
    public static void printMST(ArrayList<Edge>[] mst){
        for(int i = 0; i < mst.length; i++){
            ArrayList<Edge> shortestPath = mst[i];
            // System.out.print(i + " ");
            for(Edge e : shortestPath){
                int u = e.u;
                int v = e.v;
                int wsf = e.wt;
                System.out.println("[" + u + " " + v + " " + wsf + "]" + " ");
            }
        }
    }
    
    /*
        I/P -   9
                13
                0 1 4
                0 7 8
                1 2 8
                1 7 11
                7 8 7
                7 6 1
                2 3 7
                2 8 2
                8 6 6
                6 5 2
                3 5 14
                3 4 9
                5 4 10
        
        O/P -> 
            
            Minimum Spanning tree AKA MST
            
                                        [0 1 4] 
                                        [0 7 8] 
                                        [2 3 7] 
                                        [3 4 9] 
                                        [6 5 2] 
                                        [6 8 6] 
                                        [7 6 1] 
                                        [8 2 2] 
            
    */

    public static void minSpanningTree(int n, ArrayList<Edge>[] graph){               // prims algo
        PriorityQueue<pair> pq = new PriorityQueue<>();
        boolean[] vis = new boolean[n];
        pq.add(new pair(-1, 0, 0));
        // vis[0] = true;
        
        ArrayList<Edge>[] mst = new ArrayList[n];
        
        for(int i = 0; i < n; i++)
            mst[i] = new ArrayList<>();
            
        int edges = 0;
        while(pq.size() > 0){
            pair rem = pq.poll();
            int par = rem.par;
            int src = rem.src;
            int wt = rem.wt;
            
            if(vis[src] == true)    continue;
            vis[src] = true;
            if(par != -1)
                mst[par].add(new Edge(par, src, wt));
                edges++;
                
            for(Edge e : graph[src]){
                int v = e.v;
                int w = e.wt;
                if(!vis[v]){
                    pq.add(new pair(src, v, w));
                }
            }
            if(edges == n - 1)
                break;
        }
        printMST(mst);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++)  graph[i] = new ArrayList<>();
        for(int i = 0; i < e; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int wt = sc.nextInt();
            graph[u].add(new Edge(u, v, wt));
            graph[v].add(new Edge(v, u, wt));
        }
        minSpanningTree(n, graph);
    }
}
