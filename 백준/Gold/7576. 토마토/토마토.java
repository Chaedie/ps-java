import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tomato {
    int x;
    int y;

    Tomato(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    private static int n;
    private static int m;
    private static int[][] map;
    private static int[] dx = new int[]{1, -1, 0, 0};
    private static int[] dy = new int[]{0, 0, 1, -1};
    private static Queue<Tomato> q = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int tomato = Integer.parseInt(st.nextToken());
                map[i][j] = tomato;
                if (tomato == 1) {
                    q.add(new Tomato(i, j));
                }
            }
        }
        bfs();
        System.out.println(getMaxDay());
    }

    private static int getMaxDay() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(map[i][j], max);
                if (map[i][j] == 0) {
                    return -1;
                }
            }
        }
        return max - 1;
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            Tomato t = q.poll();
            int x = t.x;
            int y = t.y;
            for (int i = 0; i < 4; i++) {
                Integer nx = x + dx[i];
                Integer ny = y + dy[i];
                if (isValid(nx, ny)) {
                    if (map[nx][ny] == 0) {
                        q.add(new Tomato(nx, ny));
                        map[nx][ny] = map[x][y] + 1;
                    }
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