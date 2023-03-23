import java.util.*;

class Solution {
    //3번의 기회 0~10
    // S,D,T => 1제곱, 2제곱, 3제곱
    // * 해당 점수 , 이전 점수를 2배로
    // # 해당점수는 마이너스
    //*는 중첩됨 -> 
    // # 도 중첩됨
    public int solution(String dartResult) {
        dartResult += " ";
        int[] scores = new int[3];
        int index = 0;
        for (int i = 0; i < dartResult.length(); i++) {
            char cur = dartResult.charAt(i);
            if (cur == ' ') { break; }
            char next =  dartResult.charAt(i + 1);
            // 숫자면
            if ("0123456789".indexOf(cur) != -1) {
                if (cur == '1') {
                    if (next == '0') {
                        scores[index] = 10;
                        i++;
                    } else {
                        scores[index] = 1;
                    }
                } else {
                    scores[index] = Character.getNumericValue(cur);    
                }
                continue;
            }
            
            // SDT면
            if (cur == 'S') {
            } else if (cur == 'D') {
                scores[index] = (int) Math.pow(scores[index], 2);
            } else if (cur == 'T') {
                scores[index] = (int) Math.pow(scores[index], 3);
            }
            // next 가 *#이면
            if (next == '*') {
                if (index == 0) {
                    scores[index] *= 2;    
                } else {
                    scores[index] *= 2;    
                    scores[index - 1] *= 2;    
                }
                i++;
            } else if (next == '#') {
                scores[index] *= -1;
                i++;
            }
            index++;
        }
        
        return scores[0] + scores[1] + scores[2];
    }
}