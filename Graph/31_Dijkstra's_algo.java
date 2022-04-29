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
        int wsf;
        pair(int par, int src, int wsf){
            this.par = par;
            this.src = src;
            this.wsf = wsf;
        }
        public int compareTo(pair o){
            return this.wsf - o.wsf;
        }
    }

    public static void printDist(int[] dist){
        for(int val : dist){
            System.out.print(val + " ");
        }
        System.out.println();
    }
    
    public static void printSPT(ArrayList<Edge>[] spt){
        for(int i = 0; i < spt.length; i++){
            ArrayList<Edge> shortestPath = spt[i];
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
            Dist[] = 0 4 12 19 21 11 9 8 14
            
            Shortest path tree AKA SPT
            
                                        [0 1 4] 
                                        [0 7 8] 
                                        [1 2 12] 
                                        [2 8 14] 
                                        [2 3 19] 
                                        [5 4 21] 
                                        [6 5 11] 
                                        [7 6 9] 
            
    */

    public static void dijkstrasAlgo(int n, ArrayList<Edge>[] graph){
        PriorityQueue<pair> pq = new PriorityQueue<>();
        ArrayList<Edge>[] spt = new ArrayList[n - 1];
        for(int i = 0; i < n - 1; i++){
            spt[i] = new ArrayList<>();
        }
        
        pq.add(new pair(-1, 0, 0));
        int[] dist = new int[n];
        dist[0] = 0;
        Arrays.fill(dist, (int)1e9);
        int edges = 0;
        int count = 0;
        while(pq.size() > 0){
            pair rem = pq.poll();
            int par = rem.par;
            int src = rem.src;
            int wsf = rem.wsf;
            
            count ++;
            if(dist[src] != (int)1e9)continue;
            
            if(par != -1){
                spt[par].add(new Edge(par, src, wsf));
                edges++;
            }
            dist[src] = wsf;
            
            for(Edge e : graph[src]){
                if(dist[e.v] == (int)1e9)
                    pq.add(new pair(src, e.v, wsf + e.wt));
            }
            if(edges == n - 1){
                break;
            }
        }
        System.out.println(count);
        printDist(dist);
        printSPT(spt);
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
        dijkstrasAlgo(n, graph);
    }
}
