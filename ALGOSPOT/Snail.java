import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class Snail {

	static int n, m;
	static double[][] cache;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		cache = new double[1000][2000];
		
		int cases = sc.nextInt();
		while (cases-- > 0) {
			n = sc.nextInt();
			m = sc.nextInt();

			for(double[] arr : cache) {
				Arrays.fill(arr, -1);
			}
			
			System.out.println(climb(0,0));
		}
	}

	public static double climb(int days, int climbed) {

		if (days == m) {
			if (climbed >= n) return 1;
		    return 0;
		}
		
		if(cache[days][climbed] != -1)
			return cache[days][climbed];
		
		return cache[days][climbed] = 0.25 * climb(days+1, climbed+1) + 0.75 * climb(days+1, climbed+2);

	}

}