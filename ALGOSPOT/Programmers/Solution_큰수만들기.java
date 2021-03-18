package Programmers;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_큰수만들기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("4177252841", 4));
//		System.out.println(solution("1231234", 3));
//		System.out.println(solution("1924", 2));
//		System.out.println(solution("9432876", 4));
	}

	public static String solution(String number, int k) {
		StringBuilder answer = new StringBuilder();

		int n = number.length();
		int s = 0;
		int e = n - k;

		for (int i = 0; i < n - k; i++) {
			int max = -1;
			int m_index = 0;
//			System.out.println(number.substring(s, k+i+1));
			for (int j = s; j < k+i+1; j++) {
				int a = number.charAt(j) - '0';
				if (a > max) {
					m_index = j;
					max = a;
				}
			}
			answer.append(number.charAt(m_index));
			s = m_index + 1;

		}

		return answer.toString();
	}

}
