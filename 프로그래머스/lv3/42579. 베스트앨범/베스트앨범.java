import java.util.*;

class Solution {
    // Map으로 이래저래 해봐도 어차피 Map안에 List담아서 정렬해야하고 index 들고다니기도 번거로와서
    // Music Class 선언하고, implements Comparable해서 정렬가능하도록 만듬
    // 그리고 필요한대로 데이터 뽑음
    public int[] solution(String[] genres, int[] plays) {
        // max장르 찾기
        Map<String, Integer> map = new HashMap<>();
        for (int i =0; i < genres.length; i++) {
            map.put(genres[i], plays[i] + map.getOrDefault(genres[i], 0));    
        }
        
        //뮤직 세팅
        List<Music> list = new ArrayList<>();
        for (int i = 0; i < plays.length; i++) {
            list.add(new Music(genres[i], plays[i], i));
        }
        
        Collections.sort(list);
    
        // 베스트 앨범 세팅
        List<Integer> answer = new ArrayList<>();
        while (map.size() > 0) {
            String maxGenre = getMaxGenre(map);    
            setAlbum(list, answer, maxGenre);
            map.remove(maxGenre);
        }
                
        return answer.stream().mapToInt(x->x).toArray();
    }
    
    private void setAlbum(List<Music> list, List<Integer> answer, String target) {
        int i = 0;
        for (int j = 0; j < list.size(); j++) {
            Music music = list.get(j);
            if (target.equals(music.genre)) {
                answer.add(music.number);
                i++;
            }
            if (i == 2) return;
        }
    }
                
    private String getMaxGenre(Map<String, Integer> map) {
        String maxKey = "";
        int max = 0;
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            String key = entry.getKey();
            max = Math.max(max, map.get(key));
            if (max == map.get(key)) maxKey = key;
        }    
        return maxKey;
    }
    
    class Music implements Comparable<Music> {
        public String genre;
        public int play;
        public int number;
        
        Music(String genre, int play, int number){
            this.genre = genre;
            this.play = play;
            this.number = number;
        }
        
        @Override
        public int compareTo (Music m) {
            if (m.play != this.play) {
                return m.play - this.play ;
            } 
            
            return this.number -  m.number;
        }
    }
}