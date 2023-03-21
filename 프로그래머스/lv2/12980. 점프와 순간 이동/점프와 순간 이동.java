import java.util.*;

public class Solution {
    // k칸 점프, 현재 온거리 x 2로 순간이동
    // k칸 점프는 건전지 k만큼 듬
    // 
    // n % 2 == 0 이면 n = n / 2 continue;
    // n % 2 == 1 이면 n = n - 1 count++;
    public int solution(int n) {
        int count = 0;
        while (n != 0) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = n - 1;
                count++;
            }
        }
        
        return count;
    }
}