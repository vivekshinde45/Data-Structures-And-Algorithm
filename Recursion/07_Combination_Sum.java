https://leetcode.com/problems/combination-sum/



class Solution {
    public void combinationSum_Recursive(int idx, int[] nums, int target, List<List<Integer>> ans, List<Integer> list){
        if(target == 0){
            List<Integer> bans = new ArrayList<>(list);
            ans.add(bans);
            return;
        }
        for(int i = idx; i < nums.length; i++){
            int val = nums[i];
            if(target - val >= 0){
                list.add(val);
                combinationSum_Recursive(i, nums, target - val, ans, list);
                list.remove(list.size() - 1);
            }
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans  = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combinationSum_Recursive(0, candidates, target, ans, list);
        return ans;
    }
}
