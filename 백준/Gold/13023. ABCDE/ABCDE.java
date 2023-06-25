import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int m;
    private static int[][] map;
    private static boolean hasFriend;
    private static boolean[] check;
    private static List<List<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        // ! 양방향 인접 리스트 생성
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> tempList = new ArrayList<>();
            list.add(tempList);
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.get(x).add(y);
            list.get(y).add(x);
        }
        // 모든 시작점을 다 탐색해야하니까 for문 돌림
        for (int i = 0; i < n; i++) {
            check = new boolean[n];
            check[i] = true;
            dfs(0, list.get(i));
        }
        /*
            이거 그래프로 그리라는거 같은데
            그래프 그려서 bfs로 12345 이렇게 다섯개 연결된거 있는지 체크하는거인듯
            => 아님 그래프 그려서 생각해보니까 dfs로 타고타고 들어가면서 5이상이면 체크하는거임 
            근데 그럼 중복되는경우도 생기는거 아님 ? 
            => 근데 문제 출력조건이 존재하면 1 없으면 0 임  ㅋㅋ 굳
            그래프 어케 그리지
            일단 이차원 배열만들고 0 1 이면 map[i][j] = 1; map[j][i] = 1; 달아주면될듯      
            01000
            10100
            01010
            00101
            00010 
         */
        /*
            하나 타고 들어가면 1이있는지 for문으로 쭉 확인함
            1이 있으면 해당 놈으로 dfs들어감
            depth가 카운트랑 같음
            체크도 필요함 check[i] 이면 넘겨야됨
         */
        //! 계속 시간초과가 떠서 다른사람 코드보니까 이차원배열이 아니라 
        //! 양방향 인접리스트로 인풋을 세팅해서 사용하더라......
        //! 그럼 모든 맵을 탐색하면서 1인지 아닌지 볼필요가없다.

        System.out.println(0);
    }

    private static void dfs(int depth, List<Integer> currentList) {
        if (depth == 4) {
            System.out.println(1);
            System.exit(0);
            return;
        }

        for (int i = 0; i < currentList.size(); i++) {
            if (!check[currentList.get(i)]) {
                check[currentList.get(i)] = true;
                dfs(depth + 1, list.get(currentList.get(i)));
                check[currentList.get(i)] = false;
            }
        }
    }
}
