https://leetcode.com/problems/first-missing-positive/




================BRUTE FORCE==================
Time  -> 0(n)
Space -> 0(n)
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int val : nums){
            set.add(val);
        }
        for(int i = 1; i <= n + 1; i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return 0;
    }
}

=================OPTIMIZED==================
Time  -> 0(n)
Space -> 0(1)
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // step 1 :- Mark ele which are out of range and manage presence of ONE
        boolean one = false;
        for(int i = 0; i < n; i++){
            if(nums[i] == 1){
                one = true;
            }
            if(nums[i] < 1 || nums[i] > n){
                nums[i] = 1;
            }
        }
        // at this point we will know that is (ONE present into array or not) with the help of (one variable pf boolean)
        if(one == false){
            return 1;
        }
        
        // step 2 :- Map ele with idx with nums[ele - 1] = -(Math.abs(nums[ele - 1]))
        for(int i = 0; i < n; i++){
            int idx = Math.abs(nums[i]);
            nums[idx - 1] = -(Math.abs(nums[idx - 1]));
        }
        // at this point we are marked every point which have the (idx + 1) as a ele present into array
        
        // step 3 :- find the first non negative number and it's (idx + 1) is our ans
        for(int i = 0; i < n; i++){
            if(nums[i] > 0){
                return i + 1;
            }
        }
        return n + 1;
    }
}
