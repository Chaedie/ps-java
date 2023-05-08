import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[][] graph;
    static boolean[] visited;
    static int n = 0;
    static int m = 0;
    static List<Integer> answers;

    public static void main(String[] args) throws IOException {
        answers = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.valueOf(st.nextToken());
            m = Integer.valueOf(st.nextToken());

            if (n == 0 && m == 0) {
                break;
            }

            graph = new int[m][n];

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    graph[i][j] = Integer.valueOf(st.nextToken());
                }
            }

            // * Solution
            // 연결요소 갯수 문제랑 똑같이,
            // 그래프에서 1이면 인접애들 (플루드필로 순회하면서)
            // 1이면 0으로 바꿔주고, 다 바꿔주고, count++ 해준다.
            int count = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][j] == 1) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            answers.add(count);
        }

        for (int i = 0; i < answers.size(); i++) {
            System.out.println(answers.get(i));
        }

        br.close();
    }

    private static int[] dx = {-1, 0, 1, -1, 0, 1, -1, 0, 1,};
    private static int[] dy = {-1, -1, -1, 0, 0, 0, 1, 1, 1};

    private static void dfs(int i, int j) {
        graph[i][j] = 0;

        for (int k = 0; k < 9; k++) {
            // i j 경계값 넘어가는지 확인,
            // i j 1인지 확인
            int x = i + dx[k];
            int y = j + dy[k];
            if (x < 0 || x >= m || y < 0 || y >= n) continue;
            if (graph[x][y] == 0) continue;

            dfs(x, y);
        }
    }
}


