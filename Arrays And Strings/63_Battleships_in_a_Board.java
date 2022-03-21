https://leetcode.com/problems/battleships-in-a-board/



class Solution {
    public int countBattleships(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'X'){
                    if(i == 0 && j == 0){
                        ans++;
                    }
                    else if(i == 0){
                        if(board[i][j - 1] == 'X'){
                            continue;
                        }
                        else{
                            ans++;
                        }
                    }
                    else if(j == 0){
                        if(board[i - 1][j] == 'X'){
                            continue;
                        }
                        else{
                            ans++;
                        }
                    }
                    else{
                        if(board[i - 1][j] == '.' && board[i][j - 1] == '.'){
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
// ======================================CLEAN CODE========================================
class Solution {
    public int countBattleships(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'X'){
                    if(i == 0 && j == 0){
                        ans++;
                    }
                    else if(i == 0){
                        if(board[i][j - 1] != 'X'){
                            ans++;
                        }
                    }
                    else if(j == 0){
                        if(board[i - 1][j] != 'X'){
                            ans++;
                        }
                    }
                    else{
                        if(board[i - 1][j] == '.' && board[i][j - 1] == '.'){
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
