package p04_bruteforce_simulation;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_11068 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int origin = sc.nextInt();

            int ans = 1;

            for (int b = 2; b <= 64; b++) {
                ans = 1;
                ArrayList<Integer> modulars = new ArrayList<>();

                int num = origin;

                while (num > 0) {
                    int temp = num % b;
                    modulars.add(temp);
                    num /= b;
                }

                int size = modulars.size();

                // System.out.println(modulars.toString());

                for (int j = 0; j < size / 2; j++) {
                    if (modulars.get(j) != modulars.get(size - j - 1)) {
                        ans = 0;
                    }
                }

                if (ans == 1) {
                    break;
                }
            }

            System.out.println(ans);
        }

        sc.close();
    }
}
