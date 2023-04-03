import java.util.*;

class Solution {
    public int solution(int[][] board) {
        // 2차원 배열 순회하면서
        // 지뢰있으면 (1이면) 주변을 -1로 만들기
        // 그래서 순회끝나고나면 0의 갯수 세서 return
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0 ;j < board.length; j++) {
                if (board[i][j] == 1) {
                    makeDeadZone(board, i, j);
                } 
            }
        }
        
        int count = 0;
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0 ;j < board.length; j++) {
                if (board[i][j] == 0) {
                    count++;
                } 
            }
        }
        
        return count;
    }
    
    private void makeDeadZone(int[][] board, int x, int y) {
        int len = board.length - 1;
        for (int i = x-1; i <= x+1; i++) {
            for (int j = y-1; j <= y+1; j++) {
                if (0 <= i && i <= len && 0 <= j && j <= len && board[i][j] != 1) {
                    board[i][j] = -1; 
                }
            }    
        }
        
        return;
    }
}