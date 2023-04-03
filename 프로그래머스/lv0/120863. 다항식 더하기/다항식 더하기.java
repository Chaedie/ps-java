import java.util.*;

class Solution {
    public String solution(String polynomial) {
        // " + " 로 스플릿한다.
        // x로 끝나는지 순회하면서 확인한다. 
            // x로 끝나는 경우 x는 없는 문자로 바꾸고 앞의 숫자를 Integer.toString()으로 변환해서 다 더해준다. 
            // 숫자가 없으면 1으로처리한다.
        String[] strs = polynomial.split(" \\+ ");

        int total = 0;
        int constant = 0;
        for (String str : strs) {
            if (str.endsWith("x")) {
                String temp = str.replaceAll("x", "");
                if (temp.length() == 0) {
                    total++;   
                } else {
                    total += Integer.valueOf(temp);
                }
            } else {
                constant += Integer.valueOf(str);
            }
        }
        
        // 00인케이스, 10인케이스, x0인케이스
        // 0x인케이스, 1x인케이스, xx인케이스
        StringBuilder sb = new StringBuilder();
        if (total == 0) {
            if (constant > 0) {
                sb.append(constant);
            }            
        } else if (total == 1) {
            sb.append("x");
            if (constant > 0) {
                sb.append(" + ");
                sb.append(constant);
            }
        } else {
            sb.append(total);
            sb.append("x");    
            if (constant > 0) {
                sb.append(" + ");
                sb.append(constant);
            }
        }
        
        String answer = new String(sb);
        return answer;
    }
}