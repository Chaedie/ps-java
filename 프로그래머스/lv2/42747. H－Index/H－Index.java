import java.util.*;

class Solution {
    //n편중, h번이상 인용된 논문이 h편 이상이고, 나머지는 h번 이하면 hindex임
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int hIndex = 0;
        for (int i = 0; i < citations.length; i++) {
            if (citations[citations.length - 1 - i] >= i + 1) {
                hIndex = i + 1;
            } else {
                break;
            }
        }
        
        return hIndex;
    }
    // 0,1,3,5,6
}