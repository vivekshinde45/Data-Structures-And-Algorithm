https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/




class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        
        int num1 = tops[0];
        int num2 = bottoms[0];
        int i = 0;
        
        while(i < n && count1 != (int)1e9){
            if(tops[i] == num1){
                // nothing to do
            }
            else if(bottoms[i] == num1){
                count1++;
            }
            else{
                count1 = (int)1e9;
            }
            i++;
        }
        i = 0;
        while(i < n && count2 != (int)1e9){
            if(bottoms[i] == num1){
                // nothing to do
            }
            else if(tops[i] == num1){
                count2++;
            }
            else{
                count2 = (int)1e9;
            }
            i++;
        }
        i = 0;
        while(i < n && count3 != (int)1e9){
            if(bottoms[i] == num2){
                // nothing to do
            }
            else if(tops[i] == num2){
                count3++;
            }
            else{
                count3 = (int)1e9;
            }
            i++;
        }
        i = 0;
        while(i < n && count4 != (int)1e9){
            if(tops[i] == num2){
                // nothing to do
            }
            else if(bottoms[i] == num2){
                count4++;
            }
            else{
                count4 = (int)1e9;
            }
            i++;
        }
        int result = Math.min(Math.min(count3, count4), Math.min(count1, count2));
        return result != (int)1e9 ? result : -1;
    }
}
