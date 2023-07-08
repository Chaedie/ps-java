import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int m;
    private static int[][] map;
    private static int count;

    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = chars[j] - '0';
            }
        }

        map[0][0] = 0;
        bfs(0, 0);
        System.out.println(count);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, 1});
        while (!q.isEmpty()) {
            int curX = q.peek()[0];
            int curY = q.peek()[1];
            int curCount = q.peek()[2];
            q.poll();
            count++;
            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if (nextX == n - 1 && nextY == m - 1) {
                    count = curCount + 1;
                    return;
                }
                if (isValid(nextX, nextY) && map[nextX][nextY] == 1) {
                    q.add(new int[]{nextX, nextY, curCount + 1});
                    map[nextX][nextY] = 0;
                }
            }


        }
    }

    private static boolean isValid(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return false;
        }
        return true;
    }
}
