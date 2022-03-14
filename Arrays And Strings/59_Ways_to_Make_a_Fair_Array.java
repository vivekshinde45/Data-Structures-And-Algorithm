https://leetcode.com/problems/ways-to-make-a-fair-array/




class Solution {
    public int waysToMakeFair(int[] nums) {
        int n = nums.length;
        int[] oddSum = new int[n];
        int[] evenSum = new int[n];
        
        int odd = 0;
        int even = 0;
        for(int i = 0; i < n; i++){
            if(i % 2 == 0){
                even += nums[i];
            }
            else{
                odd += nums[i];
            }
            oddSum[i] = odd;
            evenSum[i] = even;
        }
        
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(i == 0){
                int nos = evenSum[n - 1] - nums[i];
                int nes = oddSum[n - 1];
                
                if(nos == nes){
                    ans++;
                }
                continue;
            }
            int nos = evenSum[i - 1] + oddSum[n - 1] - oddSum[i];
            int nes = oddSum[i - 1] + evenSum[n - 1] - evenSum[i];
            if(nos == nes){
                ans++;
            }
        }
        return ans;
    }
}
