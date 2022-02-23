https://leetcode.com/problems/maximum-product-of-three-numbers/


Time 0(n), Space 0(1)
class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        int min1 = (int)1e9;
        int min2 = (int)1e9;
        int max1 = -(int)1e9;
        int max2 = -(int)1e9;
        int max3 = -(int)1e9;
        
        for(int i = 0; i < n; i++){
            // max check
            if(nums[i] > max1){
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            }
            else if(nums[i] > max2){
                max3 = max2;
                max2 = nums[i];
            }
            else if(nums[i] > max3){
                max3 = nums[i];
            }
            // min check
            if(nums[i] < min1){
                min2 = min1;
                min1 = nums[i];
            }
            else if(nums[i] < min2){
                min2 = nums[i];
            }
        }
        // System.out.println(min1);
        // System.out.println(min2);
        // System.out.println(max1);
        // System.out.println(max2);
        // System.out.println(max3);
        
        int ans1 = -(int)1e9;
        if(max1 != -(int)1e9 && max2 != -(int)1e9 && max3 != -(int)1e9){
            ans1 = (max1 * max2 * max3);
            // System.out.println("max" + ans1);
        }
        int ans2 = 0;
        if(min1 != (int)1e9 && min2 != (int)1e9){
            ans2 = (min1 * min2 * max1);
            // System.out.println("min" + ans2);
        }
        return Math.max(ans1, ans2);
    }
}
