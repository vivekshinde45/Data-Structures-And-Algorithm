https://leetcode.com/problems/find-all-duplicates-in-an-array/



===================BRUTE FORCE===================
Time  -> 0(n)
Space -> 0(n)
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val : nums){
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for(int val : nums){
            if(map.containsKey(val)){
                int frq = map.get(val);
                if(frq > 1){
                    list.add(val);
                    map.remove(val);
                }
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
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int val : nums){
            int idx = Math.abs(val) - 1;
            if(nums[idx] < 0){
                list.add(Math.abs(val));
            }
            nums[idx] = -nums[idx];
        }
        return list;
    }
}
