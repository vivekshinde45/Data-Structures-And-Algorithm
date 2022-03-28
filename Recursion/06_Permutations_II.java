https://leetcode.com/problems/permutations-ii/




class Solution {
    public void permuteUnique_Recursive(int[] nums, List<List<Integer>> ans, List<Integer> list){
        if(list.size() == nums.length){
            List<Integer> bans = new ArrayList<>(list);
            ans.add(bans);
            // System.out.println(list);
            return;
        }
        int prev = -11;
        for(int i = 0; i < nums.length; i++){
            int val = nums[i];
            if(prev != nums[i] && nums[i] > -11){
                nums[i] = -11;
                list.add(val);
                permuteUnique_Recursive(nums, ans, list);
                nums[i] = val;
                list.remove(list.size() - 1);
                prev = nums[i];
            }
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        permuteUnique_Recursive(nums, ans, new ArrayList<>());
        return ans;
    }
}
