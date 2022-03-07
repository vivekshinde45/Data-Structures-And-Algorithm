https://leetcode.com/problems/push-dominoes/



class Solution {
    public void fillChar(char[] arr, int left, int right, char ch){
        for(int i = left; i < right; i++){
            arr[i] = ch;
        }
    }
    
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        dominoes = "L" + dominoes + "R";
        // System.out.println(dominoes);
        char[] domino = dominoes.toCharArray();
        int idx = 0;
        char left = 'L';
        for(int i = 1; i <= n + 1; i++){
            char right = dominoes.charAt(i);
            if(right != '.'){
                if(left == 'L' && right == 'L'){
                    fillChar(domino, idx + 1, i, 'L');
                }
                else if(left == 'R' && right == 'R'){
                    fillChar(domino, idx + 1, i, 'R');
                }
                else if(left == 'R' && right == 'L'){
                    int length = i - idx - 1;
                    if(length % 2 == 0){
                        // even
                        int mid = (i + idx) / 2;
                        fillChar(domino, idx + 1, mid + 1, 'R');
                        fillChar(domino, mid + 1, i, 'L');
                    }
                    else{
                        // odd
                        int mid = (i + idx) / 2;
                        fillChar(domino, idx + 1, mid, 'R');
                        fillChar(domino, mid + 1, i, 'L');
                    }
                }
                left = right;
                idx = i;
            }
        }
        // String ans = "";                              // GIVES TLE         
        // for(int i = 1; i < domino.length - 1; i++){
        //     ans += domino[i];
        // }
        // used string builder because in JAVA the String are immutable so while appending the charaters the new string are created in string pool area
        StringBuilder str = new StringBuilder();
        for(int i = 1; i < domino.length - 1; i++){
            str.append(domino[i]);
        }
        return str.toString();
    }
}
