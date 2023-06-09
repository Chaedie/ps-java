import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = new int[9];
        for (int i = 0; i < 9; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
        }
        int sum = Arrays.stream(inputs).reduce((acc, cur) -> acc + cur).getAsInt();
        Arrays.sort(inputs);
        // 왼 오 로 나눠서 왼쪽 오른쪽 두개를 뺴봄
        // 100보다 작으면 오른쪽을 내리고
        // 100보다 크면 왼쪽을 올림
        int lt = 0;
        int rt = 8;
        sum -= inputs[lt] + inputs[rt];
        while (lt < rt) {
            if (sum == 100) {
                printAnswers(inputs, lt, rt);
                return;
            } else if (sum < 100) {
                sum += inputs[rt--];
                sum -= inputs[rt];
            } else if (sum > 100) {
                sum += inputs[lt++];
                sum -= inputs[lt];
            }
        }
    }

    static void printAnswers(int[] inputs, int lt, int rt) {
        for (int i = 0; i < 9; i++) {
            if (i == lt || i == rt) {
                continue;
            }
            System.out.println(inputs[i]);
        }
    }
}
