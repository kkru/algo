package Programmers;

public class Solution_2n≈∏¿œ∏µ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(4));
	}

	static int[] dp;
	static final int MOD = 1000000007;

	public static int solution(int n) {
		dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;

		return tiling(n);
	}

	public static int tiling(int n) {

		int ret = dp[n];

		if (ret != 0) {
			return ret;
		}

		return dp[n] = (tiling(n-2) + tiling(n-1)) % MOD;
	}

}
