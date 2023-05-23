import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Integer> stack = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());

        while (n-- > 0) {
            StringBuilder answer = new StringBuilder();
            String[] strs = br.readLine().split(" ");
            for (int i = 0; i < strs.length; i++) {
                StringBuilder sb = new StringBuilder();
                answer.append(sb.append(strs[i]).reverse() + " ");
            }
            System.out.println(answer);
        }

        br.close();
    }
}