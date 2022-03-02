https://leetcode.com/problems/valid-palindrome-ii/



class Solution {
    public boolean isPalindrome(String s, int i, int j){
        while(i <= j){
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            if(ch1 == ch2){
                i++;
                j--;
            }
            else{
                return false;
            }
        }
        return true;
    }
    
    public boolean validPalindrome(String s) {
        int n = s.length();
        int i = 0;
        int j = n - 1;
        boolean flag = false;
        while(i <= j){
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            
            if(ch1 == ch2){
                i++;
                j--;
            }
            else{
                // check for two cases
                // case1 : skiped the (i'th) character and check another string is palindrom or not
                // case1 : skiped the (j'th) character and check another string is palindrom or not
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
        }
        return true;
    }
}
