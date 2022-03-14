https://leetcode.com/problems/construct-target-array-with-multiple-sums/



class Solution {
    public boolean isPossible(int[] arr) {
        int n = arr.length;
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        for(int val : arr){
            pq.add((long)val);
            sum += val;
        }
        
        while(pq.peek() != 1){
            long top = pq.poll();
            sum = sum - top;
            if(sum <= 0 || sum >= top){
                return false;
            }
            top = top % sum;
            sum = sum + top;
            pq.add(top > 0 ? top : sum);
        }
        return true;
    }
}
