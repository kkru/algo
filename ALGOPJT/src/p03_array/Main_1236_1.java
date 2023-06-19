package p03_array;

import java.util.Scanner;

public class Main_1236_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        char[][] castle = new char[N][M];

        for (int i = 0; i < N; i++) {
            castle[i] = sc.next().toCharArray();
        }

        boolean[] row = new boolean[N];
        boolean[] col = new boolean[M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (castle[i][j] == 'X') {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        int row_count = 0;
        int col_count = 0;
        for (int i = 0; i < N; i++) {
            if (!row[i]) {
                row_count++;
            }
        }
        for (int i = 0; i < M; i++) {
            if (!col[i]) {
                col_count++;
            }
        }

        System.out.println(Math.max(row_count, col_count));

        sc.close();
    }
}
