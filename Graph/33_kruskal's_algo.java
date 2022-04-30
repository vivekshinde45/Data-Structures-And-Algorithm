 FINDING THE MINIMUM WEIGHT TO CONNECT ALL V VTCES OF THE GIVEN GRAPH


import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int v = Integer.parseInt(br.readLine());
    int e = Integer.parseInt(br.readLine());

    int[][] edges = new int[e][3];
    for (int i = 0; i < e; i++) {
      String[] st = br.readLine().split(" ");
      edges[i][0] = Integer.parseInt(st[0]);
      edges[i][1] = Integer.parseInt(st[1]);
      edges[i][2] = Integer.parseInt(st[2]);
    }

    System.out.println(minCostToSupplyWater(v, edges));
  }

  static int[] par;
  static int[] rank;
  static int edges = 0;
  
  static int findPar(int u){
      if(par[u] == u){
          return u;
      }
      par[u] = findPar(par[u]);
      return par[u];
  }
  
  static void merge(int p1, int p2){
      if(rank[p1] < rank[p2]){
          par[p1] = p2;
      }
      else if(rank[p1] > rank[p2]){
          par[p2] = p1;
      }
      else{
          par[p2] = p1;
          rank[p1]++;
      }
      edges++;
  }

  public static class Pair implements Comparable<Pair> {
    int u;
    int v;
    int wt;

    Pair(int u, int v, int wt) {
      this.u = u;
      this.v = v;
      this.wt = wt;
    }

    @Override
    public int compareTo(Pair o) {
      return this.wt - o.wt;
    }
  }

  public static int minCostToSupplyWater(int n, int[][] pipes) {
    PriorityQueue<Pair> pq = new PriorityQueue<>();
    for(int[] edge : pipes){
        int u = edge[0];
        int v = edge[1];
        int w = edge[2];
        pq.add(new Pair(u, v, w));
    }
    par = new int[n + 1];
    rank = new int[n + 1];
    
    for(int i = 0; i <= n; i++){
        par[i] = i;
        rank[i] = 0;
    }
    
    int min_Cost = 0;
    while(pq.size() > 0){
        Pair rem = pq.poll();
        int u = rem.u;
        int v = rem.v;
        int wt = rem.wt;
        
        int p1 = findPar(u);
        int p2 = findPar(v);
        
        if(p1 != p2){
            merge(p1, p2);
            min_Cost += wt;
        }
        if(edges == n - 1){
            return min_Cost;
        }
    }
    return min_Cost;
  }
}
