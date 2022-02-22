https://leetcode.com/problems/max-chunks-to-make-sorted-ii/




class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] leftMax = new int[n + 1];
        int[] rightMin = new int[n + 1];
        Arrays.fill(leftMax, -(int)1e9);
        Arrays.fill(rightMin, (int)1e9);
        
        int max = -(int)1e9;
        for(int i = 0; i < n; i++){
            max = Math.max(max, arr[i]);
            leftMax[i] = max;
        }
        int min = (int)1e9;
        for(int i = n - 1; i >= 0; i--){
            min = Math.min(min, arr[i]);
            rightMin[i] = min;
        }
        
        int chunks = 0;
        for(int i = 0; i < n; i++){
            int lMax = leftMax[i];
            int rMin = rightMin[i + 1];
            if(lMax <= rMin){
                chunks++;
            }
        }
        return chunks != 0 ? chunks : 1;
    }
}
