import java.util.*;

class Solution {
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    
    public int solution(int[][] maps) {
        int[][] visited = new int[maps.length][maps[0].length];
        
        bfs(maps, visited);
        
        int answer = visited[maps.length - 1][maps[0].length - 1];
        
        if (answer == 0) {
            answer = -1;
        }
        return answer;
    }
    private void bfs(int[][] maps, int[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        visited[0][0] = 1;
        while (!queue.isEmpty()){
            int[] curXY = queue.remove();
            int curX = curXY[0];
            int curY = curXY[1];
            
            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (!(0 <= nextX && nextX < maps.length && 0 <= nextY && nextY < maps[0].length)) 
                    continue;
                
                if (visited[nextX][nextY] <= 0 && maps[nextX][nextY] == 1) {
                    visited[nextX][nextY] = visited[curX][curY] + 1;    
                    queue.add(new int[]{nextX, nextY});
                }
            }    
        }
        
        
        return;
    }
}

// private static int[][] map;
// private static int min;
// public int solution(int[][] maps) {
//     // 1 길
//     // 0 벽
//     map = maps;
//     min = Integer.MAX_VALUE;
//     dfs(0,0,0);

//     return min == Integer.MAX_VALUE ? -1 : min + 1;
// }
// private void dfs(int x, int y, int count) {
//     if (count >= min) { return; }
//     if (x == map.length-1 && y == map[0].length-1) {
//         min = Math.min(min, count);
//         return;
//     }
//     if (isValidCoords(x-1, y)) { 
//         map[x][y] = 0;
//         dfs(x-1, y, count+1);
//         map[x][y] = 1;
//     }
//     if (isValidCoords(x+1, y)) { 
//         map[x][y] = 0;
//         dfs(x+1, y, count+1); 
//         map[x][y] = 1;
//     }
//     if (isValidCoords(x, y+1)) { 
//         map[x][y] = 0;
//         dfs(x, y+1, count+1); 
//         map[x][y] = 1;
//     }
//     if (isValidCoords(x, y-1)) { 
//         map[x][y] = 0;
//         dfs(x, y-1, count+1); 
//         map[x][y] = 1;
//     }
//     return;
// }
// private boolean isValidCoords(int x, int y) {
//     return 0 <= x && x < map.length && 0 <= y && y < map[0].length && map[x][y] == 1;
// }