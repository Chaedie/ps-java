import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringBuilder answer = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb.append(br.readLine());

        int pos = 0;
        while (pos < sb.length()) {
            if (sb.charAt(pos) == '<') {
                int right = findCloseTag(pos);
                answer.append(sb.substring(pos, right));
                pos = right;
            }

            for (int i = pos; i < sb.length(); i++) {
                if (sb.charAt(i) == '<') {
                    answer.append(new StringBuilder(sb.substring(pos, i)).reverse());
                    pos = i;
                    break;
                } else if (sb.charAt(i) == ' ') {
                    answer.append(new StringBuilder(sb.substring(pos, i)).reverse());
                    pos = i + 1;
                    answer.append(' ');
                    break;
                } else if (i == sb.length() - 1) {
                    answer.append(new StringBuilder(sb.substring(pos, i + 1)).reverse());
                    pos = i + 1;
                    break;
                }
            }
        }

        System.out.println(answer);
    }

    static int findCloseTag(int pos) {
        for (int i = pos; i < sb.length(); i++) {
            if (sb.charAt(i) == '>') {
                return i + 1;
            }
        }
        return -1;
    }
}