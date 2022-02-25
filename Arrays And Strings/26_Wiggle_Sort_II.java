https://leetcode.com/problems/wiggle-sort-ii/




=============== Brute Force ================
Time  -> 0(nlong)
Space -> 0(n)

class Solution {
    public void print1D(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int j = n - 1;
        int[] arr = new int[n];
        int i = 1;
        while(j >= 0){
            if(i < n){
                arr[i] = nums[j];
                j--;
                i += 2;
            }
            if(i >= n){
                i = 0;
            }
        }
        // print1D(arr);
        for(int idx = 0; idx < n; idx++){
            nums[idx] = arr[idx];
        }
    }
}
