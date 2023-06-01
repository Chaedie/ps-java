import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = br.readLine()) != null) {
            StringBuilder sb = new StringBuilder();
            int countLower = 0;
            int countUpper = 0;
            int space = 0;
            int number = 0;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if ('a' <= ch && ch <= 'z') {
                    countLower++;
                }
                if ('A' <= ch && ch <= 'Z') {
                    countUpper++;
                }
                if ('0' <= ch && ch <= '9') {
                    number++;
                }
                if (ch == ' ') {
                    space++;
                }
            }
            sb.append(countLower).append(" ");
            sb.append(countUpper).append(" ");
            sb.append(number).append(" ");
            sb.append(space).append(" ");
            System.out.println(sb);
        }
    }
}
