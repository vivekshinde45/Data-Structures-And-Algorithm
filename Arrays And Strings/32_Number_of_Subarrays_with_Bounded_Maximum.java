https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/




class Solution {
    public int numSubarrayBoundedMax(int[] arr, int left, int right) {
        int n = arr.length;
        int prevCount = 0;
        int ans = 0;
        int si = 0;
        int ei = 0;
        while(ei < n){
            // case I -> left <= ele <= right
            if(arr[ei] >= left && arr[ei] <= right){
                prevCount = ei - si + 1;  // number of subArray possible ending at ele
                ans += prevCount;
            }
            // case II -> ele < left
            else if(arr[ei] < left){
                ans += prevCount;
            }
            // case III -> ele > right
            else{
                si = ei + 1;
                prevCount = 0;
            }
            ei++;
        }
        return ans;
    }
}
