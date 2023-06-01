import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();

        int[] answers = new int[26];
        Arrays.fill(answers, -1);
        for (int i = 0; i < chars.length; i++) {
            if (answers[chars[i] - 'a'] == -1) {
                answers[chars[i] - 'a'] = i;
            }
        }

        for (int i = 0; i < 26; i++) {
            System.out.print(answers[i] + " ");
        }
    }
}
