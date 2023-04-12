import java.util.*;

class Solution {
    // 총 실행시간 출력
    // cache hit == 1
    // cache miss == 5
    private Map<String, Integer> cache = new HashMap<>();
    
    public int solution(int cacheSize, String[] cities) {
        int time = 0;
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            // cache에 값이 있는지 없는지 확인하기
            if (cache.containsKey(city)) {
                // 있으면 hit하고, time값 변경 time += 1;(cache.put())
                cache.put(city, time);
                time += 1;
            } else {
                // 없으면 miss 하고, time값 추가 time += 5;(chache.put())
                cache.put(city, time);
                time += 5;
            }
            // size확인하고 size넘어갔으면 순회하면서 가장 time값 낮은 캐쉬 삭제하기
            if (cache.size() > cacheSize) {
                deleteCacheByLRU();
            }
        }
        
        return time;
    }
    
    //time값 낮은 cache 삭제하기
    private void deleteCacheByLRU() {
        int minTime = Integer.MAX_VALUE;
        String LRUKey = "";
        for (String key: cache.keySet()) {
            int value = cache.get(key);
            minTime = Math.min(minTime, value);
            if (minTime == value) LRUKey = key;
        }
        cache.remove(LRUKey);
    }
}