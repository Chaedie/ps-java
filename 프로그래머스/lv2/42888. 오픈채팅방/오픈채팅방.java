import java.util.*;

class Solution {
    
    private Map<String, String> map;
    
    private List<String> list;
    
    public String[] solution(String[] record) {
        map = initMap(record);
        list = setResultList(record);
       
        return list.stream().toArray(String[]::new);
    }
    
    private List<String> setResultList(String[] record) {
        List<String> list = new ArrayList<>();
        for (String str: record) {
            StringBuilder sb = new StringBuilder();
            String[] strs = str.split(" ");
            String order = strs[0];
            String id = strs[1];
            String nick = map.get(id);
            if (order.equals("Enter")) {
                sb.append(nick);
                sb.append("님이 들어왔습니다.");
                list.add(sb.toString());
            } else if (order.equals("Leave")) {
                sb.append(nick);
                sb.append("님이 나갔습니다.");
                list.add(sb.toString());
            }
        }
        return list;
    }
        
    
    private Map<String, String> initMap(String[] record) {
        Map<String, String> map = new HashMap<>();
        for (String str: record) {
            String[] strs = str.split(" ");
            String order = strs[0];
            String id = strs[1];
            if (order.equals("Leave")) continue;
            
            String nick = strs[2];
            map.put(id, nick);

        }
        return map;
    }
}