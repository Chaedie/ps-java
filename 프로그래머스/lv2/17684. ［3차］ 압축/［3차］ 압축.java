import java.util.*;

class Solution {
    // 현재 사전에 K가 있으나 두번째 글자까지인 KA는 없음 
    // 있는 K 출력, KA는 dict에 추가
    // A는 있으나 AK는 없음
    // A 색인 출력, AK 등록
    // K 있음 -> KA 있음 -> KAO 없음 등록
    // KA출력
    public int[] solution(String msg) {
        Map<String, Integer> dict = initDict();
        List<Integer> list = new ArrayList<>();
        
        // msg를 한글자씩 순회하면서
        for (int i = 0; i < msg.length(); i++) {
            // dict에 없는 숫자가 나올때까지 글자 추가
            StringBuilder sb = new StringBuilder();
            String key = "";
            for (int j = i; j < msg.length(); j++) {
                sb.append(msg.charAt(j));
                // dict에 있으면 다음 글자 확인
                if (dict.containsKey(sb.toString())) {
                    key = sb.toString();
                } else {
                    //dict에 없으면 dict에 추가하고 나가서 이전 글자의 인덱스 출력하기
                    dict.put(sb.toString(), dict.size() + 1);
                    break;
                }
            }
            // 순회 대상 글자의 위치 이동
            i += key.length() - 1;
            list.add(dict.get(key));
        }
        
        return list.stream().mapToInt(i->i).toArray();
    }
    
    private Map<String, Integer> initDict() {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 1; i <= 26; i++) {
            char ch = (char) ('A' + i - 1); 
            map.put(Character.toString(ch), i);
        }
        return map;
    }
}