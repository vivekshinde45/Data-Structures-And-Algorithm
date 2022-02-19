https://leetcode.com/problems/next-greater-element-iii/



class Solution {
    public void print1D(char[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public int nextGreaterElement(int n) {
        char[] arr = (n + "").toCharArray();
        int len = arr.length;
        int i = len - 2;
        while(i >= 0 && arr[i] >= arr[i + 1]){
            i--;
        }
        if(i >= 0){
            int k = len - 1;
            while(arr[k] <= arr[i]){
                k--;
            }
            // swap
            char temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;
        }else{
            return -1;
        }
        String res = "";
        for(int j = 0; j <= i; j++){
            res += arr[j];
        }
        for(int j = len - 1; j > i; j--){
            res += arr[j];
        }
        long ans = Long.parseLong(res);
        // System.out.println(ans);
        return ans <= Integer.MAX_VALUE ? (int)ans : -1;
    }
}
