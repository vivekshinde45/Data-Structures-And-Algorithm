https://leetcode.com/problems/container-with-most-water/



--------- Brute Force ---------- 0(n ^ 2) ==== JAVA
class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int ans = -(int)1e9;
        
        for(int i = 0; i < n - 1; i++){
            int h1 = height[i];
            for(int j = i + 1; j < n; j++){
                int h2 = height[j];
                int ht = Math.min(h1, h2);
                int len = j - i;
                
                int area = (ht * len);
                ans = Math.max(ans, area);
            }
        }
        return ans;
    }
}


--------- Optimize ---------- 0(n)       === CPP
class Solution {
public:
    int maxArea(vector<int>& height) {
        int n = height.size();
        int ans = -(int)1e9;
        int i = 0;
        int j = n - 1;
        while(i < j){
            int h1 = height[i];
            int h2 = height[j];
            int ht = min(h1, h2);
            int len = j - i;
            ans = max(ans, (ht * len));
            if(h1 > h2){
                j--;
            }
            else{
                i++;
            }
        }
        return ans;
    }
};
