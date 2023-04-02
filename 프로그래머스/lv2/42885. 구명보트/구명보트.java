import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        // 투포인터
        // 2명만 탈수있음
        // 정렬한다음에
        // 앞에서 올라가고 위에서 내려옴
        Arrays.sort(people);
        
        int count = 0;
        int left = 0;
        int right = people.length - 1;
        while(left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
            } else {
                right--;
            }
            count++;
        }
        
        return count;
    }
}