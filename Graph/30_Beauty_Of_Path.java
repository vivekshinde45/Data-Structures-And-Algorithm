Testcase
1st
  5
  4
  abaca
  1 1 3 4
  2 3 4 5
  
2nd
  6
  6
  xzyabc
  1 3 2 5 4 6
  2 1 3 4 3 4




import java.util.*;


public class Main{
    public static class Edge {
        int nbr;
    
        Edge(int nbr) {
          this.nbr = nbr;
        }
    }
    
    public static class pair implements Comparable<pair>{
        int src;
        int occ;
        int level;
        pair(int src, int occ, int level){
            this.src = src;
            this.occ = occ;
            this.level = level;
        }
        
        public int compareTo(pair o){
            return this.occ - o.occ;
        }
    }
    
    public static int[] countChar = new int[26];
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String s = sc.next();
        int[] xlist = new int[n];
        for (int i = 0; i < m; i++) {
          xlist[i] = sc.nextInt();
        }
        int[] ylist = new int[n];
        for (int i = 0; i < m; i++) {
          ylist[i] = sc.nextInt();
        }
        ArrayList<Edge>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
          graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
          int u = xlist[i];
          int v = ylist[i];
          graph[u].add(new Edge(v));
        }
        for (int i = 0; i < n; i++) {
          int ch = s.charAt(i) - 'a';
          countChar[ch]++;
        }
        
        boolean[] vis = new boolean[n + 1];
        
        PriorityQueue<pair> pq = new PriorityQueue<>();
        int idx = s.charAt(0) - 'a';
        int occurence = countChar[idx];
        // countChar[idx]--;
        pq.add(new pair(1, occurence, 0));
        vis[0] = true;
        int max = -(int)1e9;
        
        while(pq.size() != 0){
            pair rem = pq.poll();
            int src = rem.src;
            int level = rem.level;
            
            max = Math.max(max, level);
            
            for (Edge e : graph[src]) {
                if(vis[e.nbr] == true){
                    System.out.println(-1);
                    return;
                }
                else if(!vis[e.nbr]){
                    vis[e.nbr] = true;
                    int nbrr = e.nbr - 1;
                    int i = s.charAt(nbrr) - 'a';
                    int v = countChar[i];
                    // countChar[i]--;
                    pq.add(new pair(e.nbr, v, level + 1));
                }
            }
        }
        System.out.println(max);
    }
}
