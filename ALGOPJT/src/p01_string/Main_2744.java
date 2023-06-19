package p01_string;

import java.util.Scanner;

public class Main_2744 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < in.length(); i++) {
            if (in.charAt(i) >= 'a') {
                sb.append(in.substring(i, i + 1).toUpperCase());
            } else {
                sb.append(in.substring(i, i + 1).toLowerCase());
            }

        }

        System.out.println(sb.toString());
        sc.close();
    }
}
