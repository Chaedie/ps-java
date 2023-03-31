import java.util.*;

class Solution {
    public String solution(String x, String y) {
        // 같은게 없으면 return "-1";
        // 같은거 거르는 방법은 
        //x에서 해쉬맵으로 카운트해서 몇갠지 셈
        // y에서 xMap.get해서 0이상이면 sameWordStringBuilder에 append함
        // mMap.put(number, count - 1) 해서 갯수 맞춰줘야함
        // samword를 (b+a).compare(a+b)로 sort해서 높은숫자로 return
        Map<String, Integer> map = new HashMap<>();
        String[] strX = x.split("");
        String[] strY = y.split("");
        for (String num : strX) {
            Integer count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }
        
        StringBuilder sb = new StringBuilder();
        for (String num : strY) {
            Integer count = map.getOrDefault(num, 0);
            if (count > 0) {
                sb.append(num);
                map.put(num, count - 1);
            }
        }
        
        String answer = new String(sb);
        String[] answers = answer.split("");
        Arrays.sort(answers, (a, b) -> (b+a).compareTo(a+b));
        
        String returnValue = String.join("", answers);
        if (returnValue.equals("")) {
            return "-1";
        } else if (returnValue.replaceAll("0","").equals("")) {
            return "0";
        }
        
        return returnValue;
    }
}