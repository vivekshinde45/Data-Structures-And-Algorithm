https://classroom.pepcoding.com/resources/online-java-foundation/graphs/perfect-friends-official/ojquestion




import java.io.*;
import java.util.*;

public class Main {
    
    public static class Edge{
        int src;
        int nbr;
        
        Edge(int src, int nbr){
            this.src = src;
            this.nbr = nbr;
        }
    }
    
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      int k = Integer.parseInt(br.readLine());
      
      ArrayList<Edge>[] graph = new ArrayList[n];
      for(int i = 0; i < graph.length; i++){
          graph[i] = new ArrayList<>();
      }
      
      for(int i = 0; i < k; i++){
          String str = br.readLine();
          String[] arr = str.split(" ");
          int v1 = Integer.parseInt(arr[0]);
          int v2 = Integer.parseInt(arr[1]);
          graph[v1].add(new Edge(v1,v2));
          graph[v2].add(new Edge(v2,v1));
      }
      
      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
      boolean[] vis = new boolean[n];
      for(int i = 0; i < n; i++){
          if(!vis[i]){
              ArrayList<Integer> comp = new ArrayList<>();
              isConnected(graph, i, comp, vis);
              comps.add(comp);
          }
      }
      int pair = 0;
      for(int i = 0; i < comps.size() - 1; i++){
          for(int j = i + 1; j < comps.size(); j++){
              int ans = comps.get(i).size() * comps.get(j).size();
              pair += ans;
          }
      }
      System.out.println(pair);
      
   }
  public static void isConnected(ArrayList<Edge>[] graph, int src, ArrayList<Integer> comp, boolean[] vis){
      vis[src] = true;
      comp.add(src);
      for(Edge e : graph[src]){
          if(!vis[e.nbr]){
              isConnected(graph, e.nbr, comp, vis);
          }
      }
  }
   
   

}
