package Programmers;

import java.util.Arrays;
import java.util.Stack;

public class Solution_주식가격 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(Arrays.toString(solution(new int[] { 1, 4, 0, 2, 3 })));

	}

	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];

		Stack<int[]> st = new Stack<int[]>();
		st.push(new int[] { prices[0], 0 });

		for (int i = 1; i < prices.length; i++) {

			int[] top;
			if (st.isEmpty())
				top = new int[] { prices[i], i };
			else
				top = st.peek();

			if (top[0] <= prices[i]) {
				st.push(new int[] { prices[i], i });
			} else {
				while (!st.isEmpty() && st.peek()[0] > prices[i]) {
					top = st.pop();
					answer[top[1]] = i - top[1];
				}
				st.push(new int[] { prices[i], i });
			}
		}
		int last = prices.length - 1;
		while (!st.isEmpty()) {
			int[] top = st.pop();
			answer[top[1]] = last - top[1];
			System.out.println(Arrays.toString(top));
		}

		return answer;
	}

}
