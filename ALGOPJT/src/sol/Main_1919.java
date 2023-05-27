package sol;

import java.util.Scanner;

public class Main_1919 {
    public static void main(String[] ars) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.next();
        String s2 = sc.next();

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            count2[s2.charAt(i) - 'a']++;
        }
        int answer = 0;

        for (int i = 0; i < 26; i++) {
            answer += Math.abs(count1[i] - count2[i]);
        }

        System.out.println(answer);
        sc.close();
    }
}