package Programmers;

public class Solution_스킬트리 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input = { "BACDE", "CBADF", "AECD", "BDA" };

		System.out.println(solution("CBD", input));
	}

	public static int solution(String skill, String[] skill_trees) {
		int answer = 0;

		for (int i = 0; i < skill_trees.length; i++) {
			String st = skill_trees[i];

			int len;
			int level = 0;
			for (len = 0; len < st.length(); len++) {
				String next = String.valueOf(st.charAt(len));
				if (skill.indexOf(next) > -1) {
					if (skill.indexOf(next) == level)
						level++;
					else
						break;
				}
			}

			if (len == st.length())
				answer++;
		}

		return answer;
	}

}
