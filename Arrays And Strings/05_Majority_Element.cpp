https://leetcode.com/problems/majority-element/



================= Brute Force ==================
time = 0(n)
space = 0(n)
  
class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int mx = -(int)1e9;
        map<int, int> map;
        for(int i = 0; i < nums.size(); i++){
            map[nums[i]]++;
            mx = max(mx, map[nums[i]]);
        }
        
        for(int i = 0; i < nums.size(); i++){
            int frq = map[nums[i]];
            if(frq == mx){
                return nums[i];
            }
        }
        return 0;
    }
};

================= Optimize ==================
time = 0(n)
space = 0(1)

class Solution {
public:
    int PossiblemajorityElement(vector<int>& nums){
        int val = nums[0];
        int count = 1;
        
        for(int i = 1; i < nums.size(); i++){
            if(val == nums[i]){
                // Same ele increasing the frq
                count++;
            }
            else{
                // dist ele mapping it to val
                count--;
            }
            if(count == 0){
                val = nums[i];
                count = 1;
            }
        }
        return val;
    }
    
    int majorityElement(vector<int>& nums) {
        int n = nums.size();
        
        int val = PossiblemajorityElement(nums);
        // calculating the frq of PossiblemajorityElement
        int count = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == val){
                count++;
            }
        }
        return count > (n / 2) ? val : 0;
    }
};
