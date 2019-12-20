import java.util.Scanner;

public class Fence {

    static int N;
    static int[] list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();
        while (cases-- > 0) {
            N = sc.nextInt();
            list = new int[N];

            for (int i = 0; i < N; i++) {
                list[i] = sc.nextInt();
            }
            System.out.println(solve(0, N-1));
        }
    }

    public static int solve(int left, int right) {
        int ret = 0;
        if (left == right)
            return list[left];

        int mid = (left + right) / 2;

        ret = Math.max(solve(left, mid), solve(mid + 1, right));

        int low = mid, high = mid + 1;
        int height = Math.min(list[low], list[high]);

        ret = Math.max(ret, height * 2);


        
        while (left < low || high < right) {
            if (high < right && (low == left || list[low - 1] < list[high + 1])) {
                high++;
                height = Math.min(height, list[high]);
            } else {
                low--;
                height = Math.min(height, list[low]);
            }
            ret = Math.max(ret, height * (high - low + 1));
        }

        return ret;
    }

}