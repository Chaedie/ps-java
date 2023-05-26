import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> deque = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            deque.offerLast(i + 1);
        }

        while (!deque.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                deque.offerLast(deque.pollFirst());
            }
            list.add(deque.pollFirst());
        }

        System.out.println(getResult(list));
    }

    static String getResult(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        sb.append('<');
        for (int i = 0; i < list.size(); i++) {

            sb.append(list.get(i));
            if (i == list.size() - 1) break;
            sb.append(", ");
        }
        sb.append('>');
        return sb.toString();
    }
}