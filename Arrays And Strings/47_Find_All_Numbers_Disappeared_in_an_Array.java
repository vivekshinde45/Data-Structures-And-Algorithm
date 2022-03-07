https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/



===================BRUTE FORCE===================
Time  -> 0(n)
Space -> 0(n)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int val : nums){
            set.add(val);
        }
        for(int i = 1; i <= nums.length; i++){
            if(!set.contains(i)){
                list.add(i);
            }
        }
        return list;
    }
}

===================OPTIMIZE===================
Time  -> 0(n)
Space -> 0(1)
Given array contains only [1 to n] elements so with the help of index we can solve this without using extra space
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        
        for(int val : nums){
            int idx = Math.abs(val) - 1;
            if(nums[idx] < 0){
                continue;
            }
            else{
                nums[idx] = -nums[idx];
            }
        }
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                list.add(i + 1);
            }
        }
        
        return list;
    }
}
