package levelUPCodes;

public class queens {
	public static int queensPalceCombination1D(int[] arr, int idx, int q, int qsf, String psf) {
		if(qsf == q) {
			System.out.println(psf);
			return 1;				
		}
		int count = 0;
		// 1st method
		for(int i = idx; i < arr.length; i++) {
			String path = "q" + qsf + "b" + i;
			count += queensPalceCombination1D(arr, i + 1, q, qsf + 1, psf + path + " ");
		}
		
		return count;
	}
	
	public static int queensPalceCombination1D_Sub(int[] arr, int idx, int q, int qsf, String psf) {
		if(idx == arr.length || qsf == q) {
			if(qsf == q) {
				System.out.println(psf);
				return 1;				
			}
			return 0;
		}
		int count = 0;
		String path = "q" + qsf + "b" + idx;
		count += queensPalceCombination1D_Sub(arr, idx + 1, q, qsf + 1, psf + path + " ");
		count += queensPalceCombination1D_Sub(arr, idx + 1, q, qsf, psf);
		return count;
	}
	
	public static int queensPalcePermutaion1D(int[] arr, int q, int qsf, String psf) {
		if(qsf == q) {
			System.out.println(psf);
			return 1;
		}
		int count = 0;
		for(int boxIdx = 0; boxIdx < arr.length; boxIdx++) {
			if(arr[boxIdx] != -1) {
				arr[boxIdx] = -1;
				String path = "q" + qsf + "b" + boxIdx; 
				count += queensPalcePermutaion1D(arr, q, qsf + 1, psf + path + " ");
				arr[boxIdx] = 0;
			}
		}
		return count;
	}
	
	public static int queensPalcePermutaion1D_Sub(int[] arr, int boxIdx, int q, int qsf, String psf) {
		if(boxIdx == arr.length || qsf == q) {
			if(qsf == q) {
				System.out.println(psf);
				return 1;				
			}
			return 0;
		}
		int count = 0;
		if(arr[boxIdx] != -1) {
			arr[boxIdx] = -1;
			String path = "q" + qsf + "b" + boxIdx; 
			count += queensPalcePermutaion1D_Sub(arr, 0, q, qsf + 1, psf + path + " ");
			arr[boxIdx] = 0;
		}
		count += queensPalcePermutaion1D_Sub(arr, boxIdx + 1, q, qsf, psf);
		return count;
	}
	
	public static int queensPalceCombination2D(int[][] arr, int idx, int q, int qsf, String psf) {
		if(qsf == q) {
			System.out.println(psf);
			return 1;
		}
		int n = arr.length;
		int m = arr[0].length;
		int count = 0;
		for(int i = idx; i < n * n; i++) {
			int r = i / m;
			int c = i % m;
			String path = "Queen " + qsf + " ( " + r + ", " + c + " ) ";
			count += queensPalceCombination2D(arr, i + 1, q, qsf + 1, psf + path + " ");
		}
		return count;
	}
	
	public static int queensPalceCombination2DSub(int[][] arr, int idx, int q, int qsf, String psf) {
		int n = arr.length;
		int m = arr[0].length;
		if(idx == (n * n) || qsf == q) {
			if(qsf == q) {
				System.out.println(psf);
				return 1;				
			}
			return 0;
		}
		
		int count = 0;
		
		int r = idx / m;
		int c = idx % m;
		String path = "Queen " + qsf + " ( " + r + ", " + c + " ) ";
		count += queensPalceCombination2DSub(arr, idx + 1, q, qsf + 1, psf + path + " ");
		count += queensPalceCombination2DSub(arr, idx + 1, q, qsf, psf);
		
		return count;
	}
	
	public static int queensPalcePermutation2D(int[][] arr, int idx, int q, int qsf, String psf) {
		if(qsf == q) {
			System.out.println(psf);
			return 1;
		}
		int n = arr.length;
		int m = arr[0].length;
		int count = 0;
		for(int i = 0; i < n * n; i++) {
			int r = i / m;
			int c = i % m;
			if(arr[r][c] != -1) {
				arr[r][c] = -1;
				String path = "Queen " + qsf + " ( " + r + ", " + c + " ) ";
				count += queensPalcePermutation2D(arr, i + 1, q, qsf + 1, psf + path + " ");
				arr[r][c] = 0;
			}
		}
		return count;
	}
	
	public static int queensPalcePermutation2DSub(int[][] arr, int idx, int q, int qsf, String psf) {
		int n = arr.length;
		int m = arr[0].length;
		if(idx == (n * n) || qsf == q) {
			if(qsf == q) {
				System.out.println(psf);
				return 1;				
			}
			return 0;
		}
		
		int count = 0;
		
		int r = idx / m;
		int c = idx % m;
		if(arr[r][c] != -1) {
			arr[r][c] = -1;
			String path = "Queen " + qsf + " ( " + r + ", " + c + " ) ";
			count += queensPalcePermutation2DSub(arr, 0, q, qsf + 1, psf + path + " ");
			arr[r][c] = 0;
		}
		count += queensPalcePermutation2DSub(arr, idx + 1, q, qsf, psf);
		
		return count;
	}
	
	
//	===============================N QUEENS===============================
	
	
	public static boolean isSafeToPlaceQueen(int[][] arr, int r, int c) {
//		int [][] dir = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
		
		int[][] dir = {{-1,1},{-1,-1},{1,-1},{1,1},{0,1},{0,-1},{1,0},{-1,0}};
		int n = arr.length;
		int m = arr[0].length;
		
		for(int i = 0; i < dir.length; i++) {
			for(int jump = 1; jump < Math.max(n, m); jump++) {
				int row = r + jump * dir[i][0];
				int col = c + jump * dir[i][1];
				if(row >= 0 && row < n && col >= 0 && col < n) {
					if(arr[row][col] == 1) {
						return false;
					}
				}
				else {
					break;
				}
			}			
		}
		return true;
	}
	
	public static int nQueens(int[][] arr, int idx, int q, int qsf, String psf) {
		int n = arr.length;
		if(idx == (n * n) || qsf == q) {
			if(qsf == q) {
				System.out.println(psf);
				return 1;
			}
			return 0;
		}
		int count = 0;
		for(int i = idx; i < n * n; i++) {			
			int r = i / n;
			int c = i % n;
			if(isSafeToPlaceQueen(arr, r, c) == true) {
				arr[r][c] = 1;
				String path = "Queen " + qsf + " ( " + r + ", " + c + " ) ";
				count += nQueens(arr, i + 1, q, qsf + 1, psf + path + " ");
				arr[r][c] = 0;
			}
		}
		return count;
	}
	
	public static int nQueensPermutation(int[][] arr, int idx, int q, int qsf, String psf) {
		int n = arr.length;
		if(idx == (n * n) || qsf == q) {
			if(qsf == q) {
				System.out.println(psf);
				return 1;
			}
			return 0;
		}
		int count = 0;
		for(int i = 0; i < n * n; i++) {			
			int r = i / n;
			int c = i % n;
			if(arr[r][c] != 1 && isSafeToPlaceQueen(arr, r, c) == true) {
				arr[r][c] = 1;
				String path = "Queen " + qsf + " ( " + r + ", " + c + " ) ";
				count += nQueensPermutation(arr, i + 1, q, qsf + 1, psf + path + " ");
				arr[r][c] = 0;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		int n = 4;
		int q = 4;
//		int[] arr = new int[n];
//		System.out.println(queensPalceCombination1D(arr, 0, q, 0, ""));
//		System.out.println(queensPalcePermutaion1D(arr, q, 0, ""));
//		System.out.println(queensPalcePermutaion1D_Sub(arr, 0, q, 0, ""));
		
		int[][] arr = new int[n][n];
//		System.out.println(queensPalceCombination2D(arr, 0, q, 0, ""));
//		System.out.println(queensPalceCombination2DSub(arr, 0, q, 0, ""));
//		System.out.println(queensPalcePermutation2D(arr, 0, q, 0, ""));
//		System.out.println(queensPalcePermutation2DSub(arr, 0, q, 0, ""));
		
		// N Queens
//		System.out.println(nQueens(arr, 0, q, 0, ""));
		System.out.println(nQueensPermutation(arr, 0, q, 0, ""));
		
	}
}
