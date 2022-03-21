https://leetcode.com/problems/merge-intervals/



class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        ArrayList<int[]> list = new ArrayList<>();
        
        for(int[] meeting : intervals){
            if(list.size() == 0){
                list.add(meeting);
            }
            else{
                int[] prevMeeting = list.get(list.size() - 1);
                int sp1 = prevMeeting[0];
                int ep1 = prevMeeting[1];
                int sp2 = meeting[0];
                int ep2 = meeting[1];
                if(sp2 <= ep1){
                    prevMeeting[1] = Math.max(ep1, ep2);
                }
                else{
                    list.add(meeting);
                }
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
