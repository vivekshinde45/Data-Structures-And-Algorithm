https://leetcode.com/problems/long-pressed-name/





class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if(name.length() > typed.length()){
            return false;
        }
        int i = 0;
        int j = 0;
        
        while(i < name.length() && j < typed.length()){
            char ch1 = name.charAt(i);
            char ch2 = typed.charAt(j);
            
            if(ch1 == ch2){
                i++;
                j++;
            }
            else if(i > 0 && name.charAt(i - 1) == ch2){
                j++;
            }
            else{
                return false;
            }
        }
        
        while(j < typed.length()){
            if(name.charAt(i - 1) != typed.charAt(j)){
                return false;
            }
            j++;
        }
        return i < name.length() ? false : true;
    }
}
