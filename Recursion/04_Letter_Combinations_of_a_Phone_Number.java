https://leetcode.com/problems/letter-combinations-of-a-phone-number/



class Solution {
    String[] latters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public void helper(String dig, List<String> list, String psf){
        if(dig.length() == 0){
            list.add(psf);
            return;
        }
        int idx = dig.charAt(0) - '0';
        String str = latters[idx];
        // System.out.println(str);
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            String ros = dig.substring(1);
            helper(ros, list, psf + ch);
        }
    }
    
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return new ArrayList<>();
        }
        List<String> list = new ArrayList<>();
        helper(digits, list, "");
        return list;
    }
}
