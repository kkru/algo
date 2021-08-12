package Programmers;

import java.util.HashMap;
import java.util.Map;

public class Solution_¿ß¿Â {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static Map<String, Integer> hm;

	public static int solution(String[][] clothes) {
		int answer = 1;

		hm = new HashMap<String, Integer>();

		for (int i = 0; i < clothes.length; i++) {
			hm.put(clothes[i][1], hm.getOrDefault(clothes[i][1], 0) + 1);
		}

		for (int val : hm.values()) {
			answer *= (val + 1);
		}

		return answer - 1;
	}

}
