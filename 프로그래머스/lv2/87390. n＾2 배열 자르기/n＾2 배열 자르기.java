import java.util.*;

class Solution {
    // nxn 2차원 배열생성
    // i로 채우기
    // copyOfRange
    // 123456
    // 223456
    // 333456
    // 444456
    // 555556
    // 666666
    public int[] solution(int n, long left, long right) {
        // int[][] result = new int[n][n];
        int[] answer = new int[(int)(right - left+1)];
        
        long k = left - (left % n);
        int l = 0;
        for (int i = (int) (left / n); i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = j;
                if (x < i) x = i;          
                // result[i][j] = x + 1;
                
                if (k >= left && k <= right) {
                    answer[l++] = x+1;    
                }
                if (l == (int)(right - left+1) ) return answer;
                k++;
            }    
        }
        
        // System.out.println(Arrays.deepToString(result));
        // System.out.println(Arrays.toString(answer));

        return answer;
    }
}