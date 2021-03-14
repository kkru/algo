package Programmers;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_추석트래픽 {

	public static void main(String[] args) {
		String[] lines = {
				"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"
		};
		System.out.println(solution(lines));
	}

	public static int solution(String[] lines) {
		int answer = 0;
		int[] startTimes = new int[lines.length];
		int[] endTimes = new int[lines.length];

		getTimes(lines, startTimes, endTimes);

		for (int i = 0; i < lines.length; i++) {
			int cnt = 0;
			int start = startTimes[i];
			int end = start + 1000;

			for (int j = 0; j < lines.length; j++) {
				if(startTimes[j] >= start && startTimes[j] < end)
					cnt++;
				else if(endTimes[j] >= start && endTimes[j] < end)
					cnt++;
				else if(startTimes[j] <= start && endTimes[j] >= end)
					cnt++;
				
			}
			answer = Math.max(answer, cnt);
			
			cnt = 0;
			start = endTimes[i];
			end = start +1000;
			
			for (int j = 0; j < lines.length; j++) {
				if(startTimes[j] >= start && startTimes[j] < end)
					cnt++;
				else if(endTimes[j] >= start && endTimes[j] < end)
					cnt++;
				else if(startTimes[j] <= start && endTimes[j] >= end)
					cnt++;
			}
			answer = Math.max(answer, cnt);

		}

		return answer;
	}

	private static void getTimes(String[] lines, int[] st, int[] et) {
		for (int i = 0; i < lines.length; i++) {
			String[] log = lines[i].split(" ");
			String[] resTime = log[1].split(":");
			int processTime = (int) (Double.parseDouble(log[2].substring(0, log[2].length() - 1)) * 1000);

			int startT = 0;
			int endT = 0;

			endT += 60 * 60 * 1000 * Integer.parseInt(resTime[0]);
			endT += 60 * 1000 * Integer.parseInt(resTime[1]);
			endT += (int) (Double.parseDouble(resTime[2]) * 1000);

			startT = endT - processTime + 1;

			st[i] = startT;
			et[i] = endT;
		}
	}

}
