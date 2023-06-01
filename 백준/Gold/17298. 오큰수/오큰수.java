import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> inputs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            inputs.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || inputs.get(stack.peek()) > inputs.get(i)) {
                stack.push(i);

            } else {
                while (!stack.isEmpty() && inputs.get(stack.peek()) < inputs.get(i)) {
                    inputs.set(stack.pop(), inputs.get(i));
                }
                stack.push(i);
            }
        }

        while (!stack.isEmpty()) {
            inputs.set(stack.pop(), -1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            sb.append(inputs.get(i)).append(" ");
        }
        sb.append(-1);
        System.out.println(sb);
    }
}
