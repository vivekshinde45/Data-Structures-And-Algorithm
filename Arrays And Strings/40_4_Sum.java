https://leetcode.com/problems/4sum/



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
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        if(n < 4){
            return ans;
        }
        Arrays.sort(nums);
        for(int i = 0; i < n - 3; i++){
            if(i != 0 && nums[i] == nums[i - 1]){
                continue;
            }
            for(int j = i + 1; j < n - 2; j++){
                if(j != i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                int tar = target - nums[i] - nums[j];
                List<List<Integer>> list = twoSum(nums, j + 1, n - 1, tar);
                for(List<Integer> l : list){
                    l.add(nums[i]);
                    l.add(nums[j]);
                    ans.add(l);
                }
            }
        }
        return ans;
    }
}






================================BY CALLING THREE SUM FUNCTION====================================
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
    
    public List<List<Integer>> threeSum(int[] nums, int target, int start) {
        int n = nums.length;
        // int target = 0;
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = start; i < n - 2; i++){
            if(i != start && nums[i] == nums[i - 1]){
                continue;
            }
            int trgt = target - nums[i];
            List<List<Integer>> list = twoSum(nums, i + 1, n - 1, trgt);
            for(List<Integer> l : list){
                l.add(nums[i]);
                ans.add(l);
            }
        }
        return ans;
    }
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        if(n < 4){
            return ans;
        }
        Arrays.sort(nums);
        for(int i = 0; i < n - 3; i++){
            if(i != 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int tar = target - nums[i];
            List<List<Integer>> list = threeSum(nums, tar, i + 1);
            for(List<Integer> l : list){
                l.add(nums[i]);
                ans.add(l);
            }
        }
        return ans;
    }
}
