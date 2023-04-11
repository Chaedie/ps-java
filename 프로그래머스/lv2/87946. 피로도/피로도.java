class Solution {
    private int maxResult = 0;
    private boolean[] visit;
    public int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];
        
        dfs(0, k, dungeons);
        
        return maxResult;
    }
    
    private void dfs (int d, int k, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            if (visit[i] == false && k >= dungeons[i][0]) {
                visit[i] = true;
                dfs(d+1, k - dungeons[i][1], dungeons);    
                visit[i] = false;
            }
        }
        
        maxResult = Math.max(maxResult, d);
    }
}