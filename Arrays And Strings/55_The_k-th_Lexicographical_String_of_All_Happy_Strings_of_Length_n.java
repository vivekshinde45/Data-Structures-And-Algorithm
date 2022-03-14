https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/





class Solution {
    public List<String> list = new ArrayList<>();
    
    public void getHappyString(int idx, int n, String s, String ans){
        if(ans.length() == n){
            list.add(ans);
            return;
        }
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ans.length() > 0 && ans.charAt(ans.length() - 1) == ch){
                continue;
            }
            getHappyString(0, n, s, ans + ch);
        }
    }
    public String getHappyString(int n, int k) {
        String s = "abc";
        getHappyString(0, n, s, "");
        // System.out.println(list);
        return list.size() >= k ? list.get(k - 1) : "";
    }
}
