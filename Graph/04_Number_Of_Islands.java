https://classroom.pepcoding.com/resources/online-java-foundation/graphs/count-islands-official/ojquestion




import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int m = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      int[][] arr = new int[m][n];

      for (int i = 0; i < arr.length; i++) {
         String parts = br.readLine();
         for (int j = 0; j < arr[0].length; j++) {
            arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
         }
      }

      boolean[][] vis = new boolean[m][n];
      int count = 0;
      for(int i = 0; i < m; i++){
          for(int j = 0; j < n; j++){
              if(arr[i][j] == 0 && vis[i][j] == false){
                  nOfIsland(arr, i, j, vis);
                  count++;
              }
          }
      }
      System.out.println(count);
   }
   
   public static void nOfIsland(int[][] arr, int sr, int sc, boolean[][] vis){
       if(sr < 0 || sc < 0 || sr >= arr.length || sc >= arr[0].length || vis[sr][sc] == true || arr[sr][sc] == 1){
           return;
       }
       vis[sr][sc] = true;
       nOfIsland(arr, sr - 1, sc, vis);
       nOfIsland(arr, sr, sc - 1, vis);
       nOfIsland(arr, sr + 1, sc, vis);
       nOfIsland(arr, sr, sc + 1, vis);
   }

}
