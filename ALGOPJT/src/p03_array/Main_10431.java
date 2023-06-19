package p03_array;

import java.util.Arrays;
import java.util.Scanner;

public class Main_10431 {

    static final int SIZE = 20;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int tc = 1; tc <= N; tc++) {
            sc.nextInt();

            int answer = 0;

            int[] kids = new int[SIZE];

            for (int i = 0; i < SIZE; i++) {
                int kid = sc.nextInt();

                int idx = -1;

                for (int j = 0; j < i; j++) {
                    if (kids[j] > kid) {
                        idx = j;
                        break;
                    }
                }

                if (idx >= 0) {
                    for (int j = i; j > idx; j--) {
                        kids[j] = kids[j - 1];
                    }

                    kids[idx] = kid;
                    answer += i - idx;
                } else {
                    kids[i] = kid;
                }

            }
            // System.out.println(Arrays.toString(kids));

            System.out.println(tc + " " + answer);
        }

        sc.close();
    }
}
