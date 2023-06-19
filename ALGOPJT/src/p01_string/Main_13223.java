package p01_string;

import java.util.Scanner;

public class Main_13223 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] now = sc.nextLine().split(":");
        String[] salt = sc.nextLine().split(":");

        int n_h = Integer.parseInt(now[0]);
        int s_h = Integer.parseInt(salt[0]);

        int n_m = Integer.parseInt(now[1]);
        int s_m = Integer.parseInt(salt[1]);

        int n_s = Integer.parseInt(now[2]);
        int s_s = Integer.parseInt(salt[2]);

        int now_sum = n_h * 3600 + n_m * 60 + n_s;
        int salt_sum = s_h * 3600 + s_m * 60 + s_s;

        int diff = salt_sum - now_sum;

        if (diff <= 0) {
            diff += 24 * 3600;
        }

        int d_h = diff / 3600;
        int d_m = (diff % 3600) / 60;
        int d_s = diff % 60;

        System.out.println(String.format("%02d:%02d:%02d", d_h, d_m, d_s));

        sc.close();
    }
}
