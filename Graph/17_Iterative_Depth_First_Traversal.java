https://classroom.pepcoding.com/resources/online-java-foundation/graphs/iterative-dft-official/ojquestion




import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }
   
   public static class Pair{
       int src;
       String psf;
       
       Pair(int src, String psf){
           this.src = src;
           this.psf = psf;
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
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());
      boolean[] vis = new boolean[vtces];
      
      Stack<Pair> q = new Stack<>();
      q.push(new Pair(src, src + ""));
      
      // remove --> mark --> work --> add
      
      while(q.size() > 0){
          // remove
          Pair rem = q.pop();
          
          // mark
          if(vis[rem.src] == true){
              continue;
          }
          vis[rem.src] = true;
          
          // work
          System.out.println(rem.src + "@" + rem.psf);
          
          // add
          for(Edge e : graph[rem.src]){
              q.push(new Pair(e.nbr, rem.psf + e.nbr));
          }
          
      }
   }
}
