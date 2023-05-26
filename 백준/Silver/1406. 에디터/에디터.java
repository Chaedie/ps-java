import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        leftStack = new Stack<>();
        rightStack = new Stack<>();

        String str = br.readLine();
        for (String ch : str.split("")) {
            leftStack.push(ch);
        }

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "L":
                    cursorLeft();
                    break;
                case "D":
                    cursorRight();
                    break;
                case "B":
                    delete();
                    break;
                case "P":
                    append(st.nextToken());
                    break;
            }
        }

        System.out.println(getResult());
    }

    static Stack<String> leftStack;
    static Stack<String> rightStack;

    static String getResult() {
        while (!rightStack.isEmpty()) {
            leftStack.push(rightStack.pop());
        }
        StringBuilder sb = new StringBuilder();
        for (String ch : leftStack) {
            sb.append(ch);
        }
        return sb.toString();
    }

    static void append(String str) {
        leftStack.push(str);
    }

    static void delete() {
        if (leftStack.empty()) return;
        leftStack.pop();
    }

    static void cursorLeft() {
        if (leftStack.empty()) return;
        rightStack.push(leftStack.pop());
    }

    static void cursorRight() {
        if (rightStack.empty()) return;
        leftStack.push(rightStack.pop());
    }
}