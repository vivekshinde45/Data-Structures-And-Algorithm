https://leetcode.com/problems/majority-element-ii/



================= Brute Force ==================
Time = 0(n)
Space = 0(n)
class Solution {
public:
    vector<int> majorityElement(vector<int>& nums) {
        int n = nums.size();
        map<int, int> map;
        for(int i = 0; i < n; i++){
            map[nums[i]]++;
        }
        vector<int> ans;
        for(auto const& mp : map){
            int frq = mp.second;
            if(frq > (n / 3)){
                ans.push_back(mp.first);
            }
        }
        return ans;
    }
};


================= Optimized ==================
Time = 0(n)
Space = 0(1)
class Solution {
public:
    vector<int> majorityElement(vector<int>& arr) {
        int n = arr.size();
        int val1 = arr[0];
        int cnt1 = 1;
        int val2 = arr[0];
        int cnt2 = 0;
        
        for(int i = 1; i < n; i++){
            if(arr[i] == val1){
                cnt1++;
            }
            else if(arr[i] == val2){
                cnt2++;
            }
            else{
                if(cnt1 == 0){
                    val1 = arr[i];
                    cnt1 = 1;
                }
                else if(cnt2 == 0){
                    val2 = arr[i];
                    cnt2 = 1;
                }
                else{
                    cnt1--;
                    cnt2--;
                }
            }
        }
        vector<int> ans;
        int count1 = 0;
        int count2 = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] == val1){
                count1++;
            }else if(arr[i] == val2){
                count2++;
            }
        }
        if(count1 > (n / 3)){
            ans.push_back(val1);
        }
        if(count2 > (n / 3)){
            ans.push_back(val2);
        }
        
        return ans;
    }
};
