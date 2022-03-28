https://leetcode.com/problems/combination-sum-ii/



class Solution {
    public void combinationSum2_Recursive(int idx, int[] nums, int target, List<List<Integer>> ans, List<Integer> list){
        if(target == 0){
            List<Integer> bans = new ArrayList<>(list);
            ans.add(bans);
            return;
        }
        int prev = -1;
        for(int i = idx; i < nums.length; i++){
            int val = nums[i];
            if(prev != nums[i] && target - val >= 0){
                list.add(val);
                combinationSum2_Recursive(i + 1, nums, target - val, ans, list);
                list.remove(list.size() - 1);
                prev = nums[i];
            }
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans  = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combinationSum2_Recursive(0, candidates, target, ans, list);
        return ans;
    }
}
