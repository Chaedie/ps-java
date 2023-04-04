import java.util.*;

class Solution {
    
    private List<String> substrings = new ArrayList<>();
    private List<Integer> courses = new ArrayList<>();
    
    public String[] solution(String[] orders, int[] course) {
        // DFS로 2 이상부터 부분집합을 만들고
        // 2이상인 갯수별로 Count해서 가장 많이 나온 세트를 answer에 담으면 됨
        // 오름차순으로 정렬해서 return
        for (int len: course) { courses.add(len); }

        for (String order: orders) {
            String[] ord = order.split("");
            dfs(ord, "", 0);
        }
        
        TreeMap<String, Integer> map = new TreeMap<>();
        for (String str: substrings){
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        
        int[] maxNums = new int[11];
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            String key = entry.getKey();
            Integer value = map.get(entry.getKey());
            maxNums[key.length()] = Math.max(maxNums[key.length()], value);
        }
        
        // 렝스별로 최댓값을 구함
        // 다시 순회하면서 value가 2이상이면서 최댓값이랑 같은애들을 다 앤서에 담자
        SortedSet<String> set = new TreeSet<>();
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            String key = entry.getKey();
            Integer value = map.get(entry.getKey());
            if (value >= 2 && value == maxNums[key.length()]) {
                set.add(key);
            }
        }
        
        Iterator iter = set.iterator();
        String[] answer = new String[set.size()];
        int i = 0;
        while(iter.hasNext()) {
            String str = iter.next().toString();
            answer[i++] = str;
        }
        return answer;
    }
    
    private void dfs(String[] order, String str, int index) {
        if (index == order.length) {
            if (!courses.contains(str.length())) { return; }
            String[] strs = str.split("");
            Arrays.sort(strs);
            substrings.add(String.join("", strs));
            return;
        }
        
        dfs(order, str + order[index], index + 1);
        dfs(order, str, index + 1);
        return;
    }
}