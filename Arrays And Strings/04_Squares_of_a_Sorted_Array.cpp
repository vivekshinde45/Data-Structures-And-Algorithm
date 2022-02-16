https://leetcode.com/problems/squares-of-a-sorted-array/



class Solution {
public:
    vector<int> sortedSquares(vector<int>& nums) {
        int n = nums.size();
        vector<int> ans(n);
        for(int i = 0; i < n; i++){
            int num = nums[i];
            num = num * num;
            ans[i] = num;
        }
        sort(ans.begin(), ans.end());
        return ans;
    }
};
