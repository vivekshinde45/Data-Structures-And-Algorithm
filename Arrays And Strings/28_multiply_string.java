https://leetcode.com/problems/multiply-strings/




class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int l1 = num1.length();
        int l2 = num2.length();
        int[] arr = new int[l1 + l2];
        int pf = 0; // power factor
        int i = num2.length() - 1;
        while(i >= 0){
            int iVal = num2.charAt(i) - '0';
            i--;
            
            int k = arr.length - 1 - pf;
            int j = num1.length() - 1;
            int carry = 0;
            
            while(j >= 0 || carry != 0){
                int jVal = j >= 0 ? num1.charAt(j)  - '0' : 0;
                j--;
                
                int product = iVal * jVal + carry + arr[k];
                int ele = product % 10;
                arr[k--] = ele;
                carry = product / 10;
            }
            pf++;
        }
        String ans = "";
        boolean flag = false;
        for(int idx = 0; idx < arr.length; idx++){
            if(arr[idx] == 0 && !flag){
                continue;
            }
            else{
                flag = true;
                ans += arr[idx] + "";
            }
        }
        return ans;
    }
}
