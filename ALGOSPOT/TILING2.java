import java.util.Arrays;
import java.util.Scanner;

public class TILING2 {
	
	static final int MOD = 1000000007;
	static int[] cache;
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int cases = sc.nextInt();
		while (cases-- > 0) {
			N = sc.nextInt();
			cache = new int[101];
			
			Arrays.fill(cache, -1);
			
			System.out.println(tiling(N));
		}
	}
	
	public static int tiling(int width) {
		if(width <= 1) return 1;
		
		int ret = cache[width];
		
		if(ret != -1) return ret;
		
		return cache[width] = (tiling(width-2) + tiling(width-1)) % MOD;
		
	}
}