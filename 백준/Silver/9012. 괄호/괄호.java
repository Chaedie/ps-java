import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            boolean answer = isVPS(br.readLine());
            System.out.println(answer ? "YES" : "NO");
        }

    }

    private static boolean isVPS(String strs) {
        Stack<Character> stack = new Stack<>();
        for (char ch : strs.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.size() == 0) {
                    return false;
                } else if (stack.peek() == '(') {
                    stack.pop();
                } else if (stack.peek() == ')') {
                    return false;
                }
            }
        }

        return stack.size() == 0;
    }
}