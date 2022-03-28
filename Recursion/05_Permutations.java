https://leetcode.com/problems/permutations/



class Solution {
    public void permute_Recursive(int[] nums, List<List<Integer>> ans, List<Integer> list){
        if(list.size() == nums.length){
            List<Integer> bans = new ArrayList<>(list);
            ans.add(bans);
            // System.out.println(list);
            return;
        }
        for(int i = 0; i < nums.length; i++){
            int val = nums[i];
            if(nums[i] != 11){
                nums[i] = 11;
                list.add(val);
                permute_Recursive(nums, ans, list);
                nums[i] = val;
                list.remove(list.size() - 1);
            }
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permute_Recursive(nums, ans, new ArrayList<>());
        return ans;
    }
}
