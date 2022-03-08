https://leetcode.com/problems/maximum-subarray/




class Solution {
    public int maxSubArray(int[] nums) {
        int max = -(int)1e9;
        int csum = 0;
        for(int i = 0; i < nums.length; i++){
            if(csum >= 0){
                csum += nums[i];
            }
            else{
                csum = nums[i];
            }
            max = Math.max(max, csum);
        }
        return max;
    }
}
