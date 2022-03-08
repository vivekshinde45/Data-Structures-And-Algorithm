https://leetcode.com/problems/maximum-product-subarray/




=====================BRUTE FORCE=====================
Time  -> 0(n^3)
Space -> 0(1)
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = -(int)1e9;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int product = 1;
                for(int k = i; k <= j; k++){
                    product *= nums[k];
                    max = Math.max(max, product);
                }
            }
        }
        return max;
    }
}

=====================OPTIMIZE=====================
Time  -> 0(n)
Space -> 0(1)
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = -(int)1e9;
        int cproduct = 1;
        for(int i = 0; i < n; i++){
            cproduct *= nums[i];
            max = Math.max(max, cproduct);
            if(cproduct == 0){
                cproduct = 1;
            }
        }
        cproduct = 1;
        for(int i = n - 1; i >= 0; i--){
            cproduct *= nums[i];
            max = Math.max(max, cproduct);
            if(cproduct == 0){
                cproduct = 1;
            }
        }
        return max;
    }
}
