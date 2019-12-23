import java.util.Scanner;

public class Trianglepath {

    static int N;
    static int[] load;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();
        while (cases-- > 0) {
            N = sc.nextInt();
            load = new int[N + 1];
            int max = 0;

            for (int i = 1; i <= N; i++) {
            	int[] loadcopy = load.clone();
                for (int j = 1; j <= i; j++) {
                    int num = sc.nextInt();
                    load[j] = Math.max(loadcopy[j - 1] + num, loadcopy[j] + num);
                    max = Math.max(max, load[j]);
                }
            }
            System.out.println(max);
        }
    }

}