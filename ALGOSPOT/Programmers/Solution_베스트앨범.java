package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class Solution_º£½ºÆ®¾Ù¹ü {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] solution(String[] genres, int[] plays) {
		int len = genres.length;

		Map<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < len; i++) {
			map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
		}
		ArrayList<Integer> arrlist = new ArrayList<Integer>();
		ArrayList<String> keyList = new ArrayList<String>(map.keySet());
		Collections.sort(keyList, (o1, o2)->(map.get(o2).compareTo(map.get(o1))));

		for (String key : keyList) {
			int fi = 0;
			int si = 0;
			int max = 0;

			for (int i = 0; i < len; i++) {
				if (key.equals(genres[i])) {
					if (plays[i] > max) {
						max = plays[i];
						fi = i;
					}
				}
			}

			max = -1;
			for (int i = 0; i < len; i++) {
				if (key.equals(genres[i])) {
					if (i != fi && plays[i] > max) {
						max = plays[i];
						si = i;
					}
				}
			}
			arrlist.add(fi);
			if (max != -1) {
				arrlist.add(si);
			}

		}

		return arrlist.stream().mapToInt(Integer::intValue).toArray();
	}
}
