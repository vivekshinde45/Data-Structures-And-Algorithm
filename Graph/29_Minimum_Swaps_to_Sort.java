https://practice.geeksforgeeks.org/problems/minimum-swaps/1/#




class Solution{
    //Function to find the minimum number of swaps required to sort the array.
    public class Pair implements Comparable<Pair>{
        int val;
        int idx;
        Pair(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
        @Override
        public int compareTo(Pair o){
            return this.val - o.val;
        }
    }
    
    public int minSwaps(int nums[]){
        // Code here
        int n = nums.length;
        Pair[] arr = new Pair[n];
        for(int i = 0; i < n; i++){
            arr[i] = new Pair(nums[i], i);
        }
        int ans = 0;
        Arrays.sort(arr);
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; i++){
            int oldIDX = arr[i].idx;
            if(vis[i] == true || oldIDX == i){
                continue;
            }
            else{
                int cycleLength = 0;
                int j = i;
                while(!vis[j]){
                    vis[j] = true;
                    cycleLength++;
                    j = arr[j].idx;
                }
                ans += (cycleLength - 1);
            }
        }
        return ans;
    }
}
