import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());

        List<Integer> q = new ArrayList<>();

        while (n-- > 0) {
            String[] strs = br.readLine().split(" ");

            switch (strs[0]) {
                case "push":
                    q.add(Integer.valueOf(strs[1]));
                    break;
                case "front":
                    if (q.size() == 0) {
                        System.out.println(-1);
                    } else {
                        System.out.println(q.get(0));
                    }
                    break;
                case "back":
                    if (q.size() == 0) {
                        System.out.println(-1);
                    } else {
                        System.out.println(q.get(q.size() - 1));
                    }
                    break;
                case "size":
                    System.out.println(q.size());
                    break;
                case "empty":
                    System.out.println(q.size() == 0 ? 1 : 0);
                    break;
                case "pop":
                    if (q.size() == 0) {
                        System.out.println(-1);
                    } else {
                        System.out.println(q.remove(0));
                    }
                    break;
            }
        }
    }
}