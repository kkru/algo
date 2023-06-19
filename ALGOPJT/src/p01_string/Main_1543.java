package p01_string;

import java.util.Scanner;

public class Main_1543 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String docs = sc.nextLine();
        String word = sc.nextLine();

        int count = 0;

        int startIdx = 0;

        while (true) {
            int idx = docs.indexOf(word, startIdx);

            if (idx < 0) {
                break;
            }

            startIdx = idx + word.length();
            count++;
        }

        System.out.println(count);

        sc.close();
    }
}