import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();

        int[] answers = new int[26];
        for (int i = 0; i < chars.length; i++) {
            answers[chars[i] - 'a'] += 1;
        }

        for (int i = 0; i < 26; i++) {
            System.out.print(answers[i] + " ");
        }
    }
}
