import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int[] inputs = new int[n];

        for (int i = 0; i < n; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
        }

        int cur = 1;
        for (int i = 0; i < inputs.length; i++) {
            int num = inputs[i];
            if (cur <= num) {
                while (cur <= num) {
                    stack.push(cur++);
                    sb.append("+\n");
                }
            } else if (stack.isEmpty() || stack.peek() != num) {
                System.out.println("NO");
                return;
            }


            stack.pop();
            sb.append("-\n");
        }

        System.out.println(sb);
    }
}