https://leetcode.com/problems/squares-of-a-sorted-array/



0(nlogn)                                               ---> Brute Force
class Solution {
public:
    vector<int> sortedSquares(vector<int>& nums) {
        int n = nums.size();
        vector<int> ans(n);
        for(int i = 0; i < n; i++){        0(n)
            int num = nums[i];
            num = num * num;
            ans[i] = num;
        }
        sort(ans.begin(), ans.end());     0(nlogn)
        return ans;
    }
    0(n) + 0(nlogn) = 0(nlogn)
};



0(n)                                                  --> Optimize with two pointers
class Solution {
public:
    vector<int> sortedSquares(vector<int>& nums) {
        int n = nums.size();
        vector<int> ans(n);
        
        int idx = n - 1;
        int i = 0;
        int j = n - 1;
        while(i <= j){                                  0(n)
            int num1 = (nums[i] * nums[i]);
            int num2 = (nums[j] * nums[j]);
            int val = max(num1, num2);
            ans[idx--] = val;
            if(num1 > num2){
                i++;
            }
            else{
                j--;
            }
        }
        
        return ans;
    }
};
