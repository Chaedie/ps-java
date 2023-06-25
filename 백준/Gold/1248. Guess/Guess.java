import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int n;
    private static char[][] map;
    private static boolean[] check;
    private static int[] answers;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        char[] chars = br.readLine().toCharArray();
        answers = new int[n];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                map[i][j] = chars[idx++];
            }
        }

        dfs(0);
    }

    private static void dfs(int depth) {
        if (depth == n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(answers[i] + " ");
            }
            System.out.println(sb);
            System.exit(0);
            return;
        }

        for (int i = -10; i <= 10; i++) {
            // 백트래킹 조건은 sum이 +인지 -인지 0인지 여부다. 
            answers[depth] = i;
            if (validate(depth)) {
                dfs(depth + 1);
            }
        }
    }

    private static boolean validate(int idx) {
        for (int i = 0; i <= idx; i++) {
            int sum = 0;
            for (int j = i; j <= idx; j++) {
                sum += answers[j];
                char sign = sum == 0 ? '0' : (sum > 0 ? '+' : '-');
                if (map[i][j] != sign) {
                    return false;
                }
            }
        }
        return true;
    }
}
