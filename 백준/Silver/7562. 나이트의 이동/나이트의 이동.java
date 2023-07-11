import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Night {
    int x;
    int y;
    int count;

    Night(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}

public class Main {
    private static int n;
    private static int l;
    private static boolean[][] check;
    private static int targetX;
    private static int targetY;
    private static Queue<Night> q;
    private static int[] dx = new int[]{-2, -1, 1, 2, -2, -1, 1, 2};
    private static int[] dy = new int[]{-1, -2, -2, -1, 1, 2, 2, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            q = new LinkedList<>();
            l = Integer.parseInt(br.readLine());
            check = new boolean[l][l];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            q.add(new Night(x, y, 0));
            st = new StringTokenizer(br.readLine());
            targetX = Integer.parseInt(st.nextToken());
            targetY = Integer.parseInt(st.nextToken());

            System.out.println(bfs());
        }
    }

    private static int bfs() {
        while (!q.isEmpty()) {
            Night night = q.poll();
            int x = night.x;
            int y = night.y;
            int count = night.count;
            check[x][y] = true;
            if (x == targetX && y == targetY) {
                return count;
            }
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (isValid(nx, ny)) {
                    if (!check[nx][ny]) {
                        check[nx][ny] = true;
                        q.add(new Night(nx, ny, count + 1));
                    }
                }
            }
        }
        return 0;
    }

    private static boolean isValid(int x, int y) {
        if (x < 0 || y < 0 || x >= l || y >= l) {
            return false;
        }
        return true;
    }
}
