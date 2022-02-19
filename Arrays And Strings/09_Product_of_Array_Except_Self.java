https://leetcode.com/problems/product-of-array-except-self/




// 1st Approach by using two extra arrays 1 for PREFIX and another for SUFIX taking space 0(2N) and one array for storing the answers will take 0(N) space = 0(3N) ~ 0(N)
class Solution {
    public void print1D(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n + 1];
        int[] suf = new int[n + 1];
        pre[0] = 1;
        suf[n] = 1;
        
        int p1 = 1;
        int p2 = 1;
        for(int i = 0; i < n; i++){
            p1 *= nums[i];
            pre[i] = p1;
        }
        for(int i = n - 1; i >= 0; i--){
            p2 *= nums[i];
            suf[i] = p2;
        }
        // print1D(pre);
        // print1D(suf);
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            // System.out.println(i + " -> " + pre[i - 1 >= 0 ? i - 1 : 0] + " * " + suf[i + 1]);
            if(i == 0){
                ans[i] = suf[i + 1];
            }else{
                ans[i] = pre[i - 1] * suf[i + 1];
            }
        }
        return ans;
    }
}

//  2nd approach using 0(N) space and one Array for storing the ans so here we are using 0(2N) space 
class Solution {
    public void print1D(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] suf = new int[n + 1];
        suf[n] = 1;
        int p2 = 1;
        for(int i = n - 1; i >= 0; i--){
            p2 *= nums[i];
            suf[i] = p2;
        }
        int mult = 1;
        // print1D(suf);
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            if(i == 0){
                ans[i] = suf[i + 1];
            }else{
                mult *= nums[i - 1];
                ans[i] = mult * suf[i + 1];
            }
        }
        return ans;
    }
}
