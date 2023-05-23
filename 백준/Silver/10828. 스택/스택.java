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

        for (int i = 0; i < n; i++) {
            String[] strs = br.readLine().split(" ");
            // System.out.println(Arrays.toString(strs));
            if (strs[0].equals("push")) {
                stack.add(Integer.parseInt(strs[1]));
            }
            if (strs[0].equals("top")) {
                if (stack.size() == 0) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.get(stack.size() - 1));
                }
            }
            if (strs[0].equals("size")) {
                System.out.println(stack.size());
            }
            if (strs[0].equals("empty")) {
                System.out.println(stack.size() == 0 ? 1 : 0);
            }
            if (strs[0].equals("pop")) {
                if (stack.size() == 0) {
                    System.out.println(-1);
                } else {
                    int value = stack.get(stack.size() - 1);
                    stack.remove(stack.size() - 1);
                    System.out.println(value);
                }
            }
        }

        br.close();
    }
}