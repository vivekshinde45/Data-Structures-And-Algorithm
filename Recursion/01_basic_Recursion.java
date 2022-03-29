package levelUPCodes;

public class basic_recursion {
	public static int mazePath(int sr, int sc, int dr, int dc, String psf) {
		if(sr == dr && sc == dc) {
			System.out.println(psf);
			return 1;
		}
		int count = 0;
		// horizontal
		if(sc + 1 <= dc) {
			count += mazePath(sr, sc + 1, dr, dc, psf + "h");
		}
		if(sr + 1 <= dr) {
			count += mazePath(sr + 1, sc, dr, dc, psf + "r");
		}
		if(sc + 1 <= dc && sr + 1 <= dr) {
			count += mazePath(sr + 1, sc + 1, dr, dc, psf + "d");
		}
		return count;
	}
	
	public static int mazePathWithDirectionArray(int sr, int sc, int dr, int dc, String psf, int[][] dir, String[] dirS) {
		if(sr == dr && sc == dc) {
			System.out.println(psf);
			return 1;
		}
		int count = 0;
		for(int i = 0; i < dir.length; i++) {
			int r = sr + dir[i][0];
			int c = sc + dir[i][1];
			if(r >= 0 && r <= dr && c >= 0 && c <= dc) {
				count += mazePathWithDirectionArray(r, c, dr, dc, psf + dirS[i], dir, dirS);
			}
		}
		return count;
	}
	
	public static int mazePathWithDirectionArrayWithJumps(int sr, int sc, int dr, int dc, String psf, int[][] dir, String[] dirS) {
		if(sr == dr && sc == dc) {
			System.out.println(psf);
			return 1;
		}
		int count = 0;
		for(int i = 0; i < dir.length; i++) {
			for(int jump = 1; jump <= Math.max(dr, dc); jump++) {
				int r = sr + jump * dir[i][0];
				int c = sc + jump * dir[i][1];
				if(r >= 0 && r <= dr && c >= 0 && c <= dc) {
					count += mazePathWithDirectionArrayWithJumps(r, c, dr, dc, psf + dirS[i] + jump + " ", dir, dirS);
				}				
			}
		}
		return count;
	}
	
	public static int floodFill(int[][] mat, int sr, int sc, int dr, int dc, String psf, int[][] dir, String[] dirS) {
		if(sr == dr && sc == dc) {
			System.out.println(psf);
			return 1;
		}
		mat[sr][sc] = 1;
		int count = 0;
		for(int i = 0; i < dir.length; i++) {
			int r = sr + dir[i][0];
			int c = sc + dir[i][1];
			if(r >= 0 && r <= dr && c >= 0 && c <= dc && mat[r][c] != 1) {
				count += floodFill(mat, r, c, dr, dc, psf + dirS[i] + " ", dir, dirS);
			}
		}
		mat[sr][sc] = 0;
		return count;
	}
	
	public static int floodFillWithJumps(int[][] mat, int sr, int sc, int dr, int dc, String psf, int[][] dir, String[] dirS) {
		if(sr == dr && sc == dc) {
			System.out.println(psf);
			return 1;
		}
		mat[sr][sc] = 1;
		int count = 0;
		for(int i = 0; i < dir.length; i++) {
			for(int jump = 1; jump <= Math.max(dr, dc); jump++) {
				int r = sr + jump * dir[i][0];
				int c = sc + jump * dir[i][1];
				if(r >= 0 && r <= dr && c >= 0 && c <= dc && mat[r][c] != 1) {
					count += floodFillWithJumps(mat, r, c, dr, dc, psf + dirS[i] + jump + " ", dir, dirS);
				}				
			}
		}
		mat[sr][sc] = 0;
		return count;
	}
	
	public static int floodFillWithJumpsShortestPath(int[][] mat, int sr, int sc, int dr, int dc, String psf, int[][] dir, String[] dirS) {
		if(sr == dr && sc == dc) {
			System.out.println(psf);
			return 1;
		}
		mat[sr][sc] = 1;
		int minCost = (int)1e9;
		for(int i = 0; i < dir.length; i++) {
			for(int jump = 1; jump <= Math.max(dr, dc); jump++) {
				int r = sr + jump * dir[i][0];
				int c = sc + jump * dir[i][1];
				if(r >= 0 && r <= dr && c >= 0 && c <= dc && mat[r][c] != 1) {
					minCost = Math.min(minCost, floodFillWithJumpsShortestPath(mat, r, c, dr, dc, psf + dirS[i] + jump + " ", dir, dirS));
				}				
			}
		}
		mat[sr][sc] = 0;
		return minCost;
	}
	
	public static void main(String[] args) {
		int n = 3;
		int m = 3;
//		int[][] dir = {{0, 1}, {1, 0}, {1, 1}};
//		String[] dirS = {"h", "v", "d"};
//		System.out.println(mazePath(0, 0, n - 1, m - 1, ""));
//		System.out.println(mazePathWithDirectionArrayWithJumps(0, 0, n - 1, m - 1, "", dir , dirS));
		int[][] mat = new int[n][m];
		int[][] dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
		String [] dirS = {"u", "ur", "r", "rd", "d", "ld", "l", "ul"};
//		System.out.println(floodFill(mat, 0, 0, n - 1, m - 1, "", dir, dirS));
//		System.out.println(floodFillWithJumps(mat, 0, 0, n - 1, m - 1, "", dir, dirS));
		System.out.println(floodFillWithJumpsShortestPath(mat, 0, 0, n - 1, m - 1, "", dir, dirS));
	}
}
