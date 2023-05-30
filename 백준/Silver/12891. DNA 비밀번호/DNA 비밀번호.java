import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int minA;
    static int minC;
    static int minG;
    static int minT;
    static Map<Character, Integer> map;

    static boolean isGoodString() {
        if (map.getOrDefault('A', 0) >= minA && map.getOrDefault('C', 0) >= minC && map.getOrDefault('G', 0) >= minG && map.getOrDefault('T', 0) >= minT) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());

        String str = br.readLine();
        st = new StringTokenizer(br.readLine());
        minA = Integer.valueOf(st.nextToken());
        minC = Integer.valueOf(st.nextToken());
        minG = Integer.valueOf(st.nextToken());
        minT = Integer.valueOf(st.nextToken());

        int count = 0;

        map = new HashMap<>();

        // str을 m 만큼 카운트한다.
        // 해당 카운트가 조건을 만족하면 answer++ 한다.
        // left 를 삭제하고, right를 추가한다.
        // count

        // 첫 부분문자열 세팅
        for (int i = 0; i < m; i++) {
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // 좋은수인지 판별
        if (isGoodString()) {
            count++;
        }

        int left = 0;
        int right = m - 1;
        while (right < n - 1) {
            char leftCh = str.charAt(left);
            char rightCh = str.charAt(right);

            char nextCh = str.charAt(right + 1);

            map.put(leftCh, map.getOrDefault(leftCh, 0) - 1);
            map.put(nextCh, map.getOrDefault(nextCh, 0) + 1);
            if (isGoodString()) {
                count++;
            }

            left++;
            right++;
        }

        System.out.println(count);
    }
}