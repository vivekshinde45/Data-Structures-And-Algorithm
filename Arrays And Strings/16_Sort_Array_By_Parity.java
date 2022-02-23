https://leetcode.com/problems/sort-array-by-parity/




class Solution {
    public void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        // int[] ans = new int[n];
        int idx = 0;
        for(int i = 0; i < n; i++){
            int ele = nums[i];
            if(ele % 2 == 0){
                swap(nums, idx, i);
                idx++;
            }
        }
        return nums;
    }
}
