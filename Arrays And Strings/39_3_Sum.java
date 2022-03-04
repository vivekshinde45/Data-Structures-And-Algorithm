https://leetcode.com/problems/3sum/




class Solution {
    public List<List<Integer>> twoSum(int[] nums, int left, int right, int tar){
        List<List<Integer>> ans = new ArrayList<>();
        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum == tar){
                List<Integer> list = new ArrayList<>();
                list.add(nums[left]);
                list.add(nums[right]);
                ans.add(list);
                
                while(left < right && nums[left] == nums[left + 1]){
                    left++;
                }
                while(left < right && nums[right] == nums[right - 1]){
                    right--;
                }
                
                left++;
                right--;
            }
            else if(sum < tar){
                left++;
            }
            else{
                right--;
            }
        }
        return ans;
    }
    
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int target = 0;
        List<List<Integer>> ans = new ArrayList<>();
        if(n < 3){
            return ans;
        }
        
        for(int i = 0; i < n - 2; i++){
            if(i != 0 && nums[i] == nums[i - 1]){
                continue;
            }
            // int trgt = target - nums[i];
            List<List<Integer>> list = twoSum(nums, i + 1, n - 1, -nums[i]);
            for(List<Integer> l : list){
                l.add(nums[i]);
                ans.add(l);
            }
        }
        return ans;
    }
}
