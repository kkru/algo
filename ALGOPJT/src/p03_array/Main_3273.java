package p03_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int answer = 0;

        for (int i = 0; i < n; i++) {
            int front = arr[i];

            if (front > x / 2) {
                break;
            }

            for (int j = i + 1; j < n; j++) {
                int rear = arr[j];

                if (front + rear == x) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

}
