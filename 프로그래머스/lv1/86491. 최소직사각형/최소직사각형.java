import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        // 가로세로 중 큰값이 가로로 오도록
        for (int i = 0; i < sizes.length; i++) {
            int first = sizes[i][0];
            int second = sizes[i][1];
            if (first < second) {
                sizes[i][0] = second;
                sizes[i][1] = first;
            }
        }
        
        // 가로 중 큰값, 세로 중 큰값 찾아서 곱
        int maxW = 0;
        int maxH = 0;
        for (int[] size : sizes) {
            maxW = Math.max(maxW, size[0]);
            maxH = Math.max(maxH, size[1]);
        }
        
        return maxW * maxH;
    }
}

// public int solution(int[][] sizes) {
//     int answer = 0;

//     // 가로세로 중 큰값이 가로로 오도록
//     for (int i = 0; i < sizes.length; i++) {
//         int first = sizes[i][0];
//         int second = sizes[i][1];
//         if (first < second) {
//             sizes[i][0] = second;
//             sizes[i][1] = first;
//         }
//     }

//     // 가로기준으로 내림차순 정렬
//     Arrays.sort(sizes, (x, y) -> y[0] - x[0]);

//     // 세로 중 가장 큰 값 찾기
//     int max = 0;
//     for (int[] size : sizes) {
//         max = Math.max(max, size[1]);    
//     }

//     return max * sizes[0][0];
// }