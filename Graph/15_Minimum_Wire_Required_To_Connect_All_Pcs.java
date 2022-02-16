https://classroom.pepcoding.com/resources/online-java-foundation/graphs/minimum-wire-to-connect-all-pcs-official/ojquestion




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
   
   public static class Pair implements Comparable<Pair>{
       int src;
       int asrc;
       int wt;
       
       Pair(int src, int asrc, int wt){
           this.src = src;
           this.asrc = asrc;  // arrival SOURSE
           this.wt = wt;
       }
       
       public int compareTo(Pair o){
           return this.wt - o.wt;
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
      int src = 0;
      PriorityQueue<Pair> pq = new PriorityQueue<>();
      pq.add(new Pair(src, -1, 0));
      
      while(pq.size() > 0){
          Pair rem = pq.remove();
          
          if(vis[rem.src] == true){
              continue;
          }
          vis[rem.src] = true;
          
          if(rem.asrc != -1){
              System.out.println("[" + rem.src + "-" + rem.asrc + "@" + rem.wt + "]");
          }
          
          for(Edge e : graph[rem.src]){
              if(!vis[e.nbr]){
                  pq.add(new Pair(e.nbr, e.src, e.wt));
              }
          }
      }
   }

}
