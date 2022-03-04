https://leetcode.com/problems/missing-number/




class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int val : nums){
            set.add(val);
        }
        // System.out.println(set);
        for(int i = 0; i <= n; i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return 0;
    }
}
