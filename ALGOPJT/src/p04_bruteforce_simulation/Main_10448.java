package p04_bruteforce_simulation;

import java.util.Scanner;

public class Main_10448 {

    public static int findAnswer(int[] triNums, int num) {
        int answer = 0;

        for (int j = 1; j <= 50; j++) {
            for (int k = 1; k <= 50; k++) {
                for (int l = 1; l <= 50; l++) {
                    if (triNums[j] + triNums[k] + triNums[l] == num) {
                        return 1;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] triNums = new int[51];

        for (int i = 1; i <= 50; i++) {
            triNums[i] = i * (i + 1) / 2;
        }

        for (int i = 0; i < N; i++) {
            int answer = 0;
            int num = sc.nextInt();

            answer = findAnswer(triNums, num);

            System.out.println(answer);
        }

        sc.close();

    }
}
