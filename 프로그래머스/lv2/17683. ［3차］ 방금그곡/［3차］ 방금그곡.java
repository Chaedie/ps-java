import java.util.*;

class Solution {
    private class Music {
        long time;
        String name;
        int index;
        String music;
        String playedMusic;
        
        public Music(long time, String name, int index, String music) {
            this.time = time;
            this.name = name;
            this.index = index;
            this.music = getChangedMusic(music);
            this.playedMusic = getPlayedMusic();
        }
        
        private String getChangedMusic(String music) {
            music = music.replaceAll("C#", "H");
            music = music.replaceAll("D#", "I");
            music = music.replaceAll("F#", "J");
            music = music.replaceAll("G#", "K");
            music = music.replaceAll("A#", "L");
            return music;
        }
        
        private String getPlayedMusic() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < time; i++) {
                sb.append(music.charAt(i % music.length()));
            }
            return sb.toString();
        }
        
        public boolean isMatch(String m) {
            return this.playedMusic.contains(getChangedMusic(m));
        }
        
    }
    
    private long getTimeOfMusic(String start, String end) {
        String[] starts = start.split(":");
        String[] ends = end.split(":");
        long endTime = Long.parseLong(ends[0]) * 60 + Long.parseLong(ends[1]);
        long startTime = Long.parseLong(starts[0]) * 60 + Long.parseLong(starts[1]);
        return endTime - startTime;
    }
    
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        List<Music> musicList = new ArrayList();
        for (int i = 0; i < musicinfos.length; i++) {
            // 시간계산해서 재생된 음을 get한다.
            String[] musicInfo = musicinfos[i].split(",");
            long time = getTimeOfMusic(musicInfo[0], musicInfo[1]);
            String name = musicInfo[2];
            String music = musicInfo[3];
            Music newMusic = new Music(time, name, i, music);
            // 재생된 음의 배열에서 m이랑 같은 부분이 있는 애들만 남긴다.
            if (newMusic.isMatch(m)) {
                musicList.add(newMusic);
            }
        }
        
        if (musicList.size() == 0) { return "(None)"; }
        // 여러개면 재생시간이 제일 긴 음악, 재생시간 같으면 먼저 입력된 제목
        
        // 재생시간 긴 음악을 구함, 그리고 앞에서부터 순차해서 그 maxTime이랑 같으면 return
        long maxPlayTime = 0;
        for (int i = 0; i < musicList.size(); i++) {
            long playTime = musicList.get(i).time;
            maxPlayTime = Math.max(playTime, maxPlayTime);
        }
        for (int i = 0; i < musicList.size(); i++) {
            long playTime = musicList.get(i).time;
            if (playTime == maxPlayTime) {
                return musicList.get(i).name;
            }
        }
        
        return "(None)";
    }
}