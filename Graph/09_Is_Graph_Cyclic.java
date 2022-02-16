https://classroom.pepcoding.com/resources/online-java-foundation/graphs/is-cyclic-official/ojquestion



import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }
   
   public static class Pair{
       int src;
       
       Pair(int src){
           this.src = src;
       }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      boolean[] vis = new boolean[vtces];
      
      for(int i = 0; i < vtces; i++){
          if(!vis[i]){
              boolean ans = isCyclic(graph, i, vis);
              if(ans == true){
                  System.out.println("true");
                  return;
              }
          }
      }
      System.out.println("false");
   }
   
   public static boolean isCyclic(ArrayList<Edge>[] graph, int src, boolean[] vis){
       Queue<Pair> q = new ArrayDeque<>();
       q.add(new Pair(src));
       
       while(q.size() > 0){
           Pair rem = q.remove();
           
           if(vis[rem.src] == true){
               return true;
           }
           vis[rem.src] = true;
           
           for(Edge e : graph[rem.src]){
               if(!vis[e.nbr]){
                   q.add(new Pair(e.nbr));
               }
           }
       }
       return false;
   }
}
