import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] graph;
    static boolean[] visited;
    static int n = 0;
    static int m = 0;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());

        graph = new int[1001][1001];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        // solution
        // 그래프를 그려줌
        // 연결 요소 : 섬이라고 보면 됨
        // 노드를 순회하면서 연결되어 있는 애들은 비짓체크
        // 한 노드에서 dfs 종료되면 count++
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
        br.close();
    }

    private static void dfs(int v) {
        visited[v] = true;

        for (int i = 1; i <= n; i++) {
            if (graph[v][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(i);
            }
        }
    }
}

