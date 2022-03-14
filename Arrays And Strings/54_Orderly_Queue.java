https://leetcode.com/problems/orderly-queue/



class Solution {
    public void rotateArray(char[] arr){
        char temp = arr[0];
        for(int i = 0; i < arr.length - 1; i++){
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = temp;
    }
    
    public String orderlyQueue(String s, int k) {
        char[] arr = s.toCharArray();
        String ans = "";
        if(k == 1){
            ans = s;
            for(int i = 0; i < s.length(); i++){
                rotateArray(arr);
                int diff = ans.compareTo(String.valueOf(arr));
                if(diff > 0){
                    ans = String.valueOf(arr);
                }
            }
        }
        else{
            Arrays.sort(arr);
            ans = String.valueOf(arr);
        }
        return ans;
    }
}
