https://leetcode.com/problems/sort-the-matrix-diagonally/




class Solution {
    public void countSort(int[][] mat, int row, int col){
        int n = mat.length;
        int m = mat[0].length;
        // create the map for count of numbers that are present into perticulat diagonal
        int[] map = new int[101];
        int i = row;
        int j = col;
        while(i < n && j < m){
            map[mat[i][j]]++;
            i++;
            j++;
        }
        i = row;
        j = col;
        for(int k = 1; k < 101; k++){
            while(map[k] > 0){
                mat[i][j] = k;
                map[k]--;
                i++;
                j++;
            }
        }
    }
    
    public int[][] diagonalSort(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        for(int j = 0; j < m; j++){
            countSort(mat, 0, j);
        }
        for(int i = 1; i < n; i++){
            countSort(mat, i, 0);
        }
        return mat;
    }
}
