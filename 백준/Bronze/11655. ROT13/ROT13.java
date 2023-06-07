import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());

        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);

            if ('a' <= ch && ch <= 'z') {
                ch = (char) (ch + 13);
                if (ch > 'z') {
                    ch = (char) (ch - 26);
                }
                sb.setCharAt(i, ch);
            } else if ('A' <= ch && ch <= 'Z') {
                ch = (char) (ch + 13);
                if (ch > 'Z') {
                    ch = (char) (ch - 26);
                }
                sb.setCharAt(i, ch);
            }

        }
        System.out.println(sb);
    }

}