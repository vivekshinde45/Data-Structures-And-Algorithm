https://leetcode.com/problems/pascals-triangle-ii/




class Solution {
    public List<Integer> getRow(int i) {
        List<Integer> list = new ArrayList<>();
        long val = 1;
        
        for(int j = 0; j <= i; j++){
            list.add((int)val);
            val = val * (i - j) / (j + 1);
        }
        return list;
    }
}
