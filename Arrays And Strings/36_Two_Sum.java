https://leetcode.com/problems/two-sum/



=============BRUTE FORCE==============
Time -> 0(N^2)
  
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] ans = new int[2];
        for(int i = 0; i < n; i++){
            int ele = target - nums[i];
            for(int j = i + 1; j < n; j++){
                if(nums[j] == ele){
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }
}


===================OPTIMIZE=====================
Time  -> 0(N)
Space -> 0(N)
  
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            int ele = target - nums[i];
            if(map.containsKey(ele)){
                ans[0] = i;
                ans[1] = map.get(ele);
                return ans;
            }
            else{
                map.put(nums[i], i);
            }
        }
        return new int[0];
    }
}
