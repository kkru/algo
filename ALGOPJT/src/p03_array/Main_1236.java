package p03_array;

import java.util.Scanner;

public class Main_1236 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        char[][] castle = new char[N][M];

        for (int i = 0; i < N; i++) {
            castle[i] = sc.next().toCharArray();
        }

        int row_count = 0;
        int col_count = 0;

        for (int i = 0; i < N; i++) {
            boolean found = false;
            for (int j = 0; j < M; j++) {
                if (castle[i][j] == 'X') {
                    found = true;
                    break;
                }
            }
            if (!found) {
                row_count++;
            }
        }

        for (int i = 0; i < M; i++) {
            boolean found = false;
            for (int j = 0; j < N; j++) {
                if (castle[j][i] == 'X') {
                    found = true;
                    break;
                }
            }
            if (!found) {
                col_count++;
            }
        }

        // for (int i = 0; i < N; i++) {
        // System.out.println(Arrays.toString(castle[i]));
        // }

        System.out.println(Math.max(row_count, col_count));

        sc.close();
    }
}
