https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/



Time - 0(nlogn)
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        int[] ans = {-(int)1e5, (int)1e5};
        int max = -(int)1e9;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        for(int i = 0; i < k; i++){
            int minEle = nums.get(i).get(0);
            max = Math.max(max, minEle);
            int[] grp = {minEle, 0, i};
            // 0th -> minimum ele from perticular list
            // 1st -> index of that element
            // 2nd -> index of list
            pq.add(grp);
        }
        while(true){
            int[] min = pq.poll();
            int ele = min[0];
            int idx = min[1];
            int kidx = min[2];
            // max - min[0] i.e. max - ele
            if(ans[1] - ans[0] > max - ele){
                ans[0] = ele;
                ans[1] = max;
            }
            idx++;
            List<Integer> list = nums.get(kidx);
            if(idx == list.size()){
                break;
            }
            else{
                min[0] = list.get(idx);
                min[1] = idx;
                min[2] = kidx;
                max = Math.max(max, list.get(idx));
                pq.add(min);
            }
        }
        return ans;
    }
}
