import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static StringTokenizer st;
    private static int[] times;
    private static int[] prices;
    private static boolean[] check;
    private static int max = Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        times = new int[n];
        prices = new int[n];
        check = new boolean[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            prices[i] = Integer.parseInt(st.nextToken());
        }

        // 어디부터 시작해야 좋은지 모르니까 일단 다 확인해야할것같은데??
        for (int i = 0; i < n; i++) {
            dfs(0, 0, 0);
        }
        System.out.println(max);
    }
    // 끝났는지 아닌지 언제 끝났는지 이런거 확ㅇㄴ할수가없네 
    // depth == n으로는 안된다. 

    private static void dfs(int depth, int start, int sum) {
        for (int i = start; i < n; i++) {
            // 만약 퇴사날전까지 끝이 난다면,
            if (i + times[i] <= n) {
                dfs(depth + 1, i + times[i], sum + prices[i]);
            }
        }

        // baseCase 없이 그냥 최대값을 찍으면 된다.
        max = Math.max(max, sum);
    }
}
