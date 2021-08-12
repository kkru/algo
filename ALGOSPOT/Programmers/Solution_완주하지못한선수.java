package Programmers;

import java.util.HashMap;

public class Solution_완주하지못한선수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] participant = { "mislav", "mislav", "mislav", "ana" };
		String[] completion = { "mislav", "mislav", "ana" };

		System.out.println(solution(participant, completion));
	}

	public static String solution(String[] participant, String[] completion) {
		String answer = "";

		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		for (String player : participant)
			hm.put(player, hm.getOrDefault(player, 0) + 1);
		for (String player : completion)
			hm.put(player, hm.get(player) - 1);
		
		for(String key: hm.keySet()) {
			if(hm.get(key) != 0) {
				answer= key;
			}
		}

		return answer;
	}

}
