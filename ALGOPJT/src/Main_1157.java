
import java.util.Scanner;

public class Main_1157 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] count = new int[26];

        String word = sc.next();

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= 'a') {
                count[word.charAt(i) - 'a']++;
            } else {
                count[word.charAt(i) - 'A']++;
            }
        }

        int max_cnt = 0;
        int max_i = 0;

        for (int i = 0; i < count.length; i++) {
            if (count[i] > max_cnt) {
                max_cnt = count[i];
                max_i = i;
            } else if (count[i] == max_cnt) {
                max_i = -1;
            }
        }

        // System.out.println(Arrays.toString(count) + "," + max_cnt);

        if (max_i == -1) {
            System.out.println("?");
        } else {
            System.out.println((char) ('A' + max_i));
        }

        sc.close();
    }
}
