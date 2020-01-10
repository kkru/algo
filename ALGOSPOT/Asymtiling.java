import java.util.Arrays;
import java.util.Scanner;

public class Asymtiling {
	
	static final int mod = 1000000007;
	static int[] cache;
	static int[] cache2;
	static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		cache = new int[101];
		cache2 = new int[101];
		
		int cases = sc.nextInt();
		while (cases-- > 0) {
			n = sc.nextInt();
			
			Arrays.fill(cache, -1);
			Arrays.fill(cache2, -1);
			
			System.out.println(asymmetric(n));
		}
	}
	public static int asymmetric(int width) {
		if(width % 2 == 1)
			return (tiling(width) - tiling(width/2) + mod) % mod;
		
		int ret = tiling(width);
		
		ret = (ret - tiling(width/2) + mod) % mod;
		ret = (ret - tiling(width/2 - 1) + mod) % mod;
		
		return ret;
		
	}
	public static int asymmetric2(int width) {
		if(width <= 2) return 0;
		
		if(cache2[width] != -1)
			return cache2[width];
		
		int ret = asymmetric2(width-2) % mod;
		ret = (ret + asymmetric2(width-4)) % mod;
		ret = (ret + tiling(width-3)) % mod;
		ret = (ret + tiling(width-3)) % mod;
		cache2[width] = ret;
		
		return ret;
		
	}
	
	
	public static int tiling(int width) {
		if(width <= 1) return 1;
		
		int ret = cache[width];
		
		if(ret != -1) return ret;
		
		return cache[width] = (tiling(width-2) + tiling(width-1)) % mod;
		
	}

}