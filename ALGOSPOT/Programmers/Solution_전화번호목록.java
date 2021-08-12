package Programmers;

import java.util.HashMap;

public class Solution_전화번호목록 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] in = {"12","123","1235","567","88"};
		System.out.println(solution(in));
	}

	public static boolean solution(String[] phone_book) {
		boolean answer = true;
		HashMap<String, Integer> hm = new HashMap<String, Integer>();

		for (String key : phone_book) {
			hm.put(key, hm.getOrDefault(key, 0));
		}
		
		for (int i = 0; i < phone_book.length; i++) {
			String p_number = phone_book[i];
			for (int j = 0; j < p_number.length(); j++) {
				String sub = p_number.substring(0, j);
				//System.out.println(sub + ", val :" + hm.get(sub));
				if(hm.get(sub) != null) {
					answer = false;
					break;
				}
			}
			if(!answer) {
				break;
			}
		}

		return answer;
	}
}
