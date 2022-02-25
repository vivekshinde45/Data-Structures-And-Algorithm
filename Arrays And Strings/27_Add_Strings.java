https://leetcode.com/problems/add-strings/




class Solution {
    public String addStrings(String num1, String num2) {
        String ans = "";
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        
        while(i >= 0 || j >= 0 || carry != 0){
            int ival = i >= 0 ? num1.charAt(i) - '0' : 0;
            i--;
            int jval = j >= 0 ? num2.charAt(j) - '0' : 0;
            j--;
            
            int sum = ival + jval + carry;
            ans = (sum % 10) + ans;
            carry = sum / 10;
        }
        return ans;
    }
}
