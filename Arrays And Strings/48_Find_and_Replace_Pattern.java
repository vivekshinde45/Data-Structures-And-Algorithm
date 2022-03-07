https://leetcode.com/problems/find-and-replace-pattern/


Time  -> 0(n)
Space -> 0(k + k) where k = length of pattern string
class Solution {
    public boolean isMatchPattern(String s1, String s2){
        // System.out.println("Pattern = " + s1);
        // System.out.println("Word = " + s2);
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < s2.length(); i++){
            char chp = s1.charAt(i);   // pattern character
            char chw = s2.charAt(i);   // word character
            if(map.containsKey(chp)){
                char ch = map.get(chp);
                if(ch != chw){
                    return false;
                }
            }
            else{
                if(set.contains(chw)){
                    return false;
                }
                map.put(chp, chw);
                set.add(chw);
            }
        }
        return true;
    }
    
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();
        for(String str : words){
            if(isMatchPattern(pattern, str) == true){
                list.add(str);
            }
        }
        return list;
    }
}
