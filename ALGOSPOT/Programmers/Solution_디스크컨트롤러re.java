package Programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_디스크컨트롤러re {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new int[][] { { 0, 3 }, { 1, 9 }, { 2, 6 } }));
	}

	static class Job {
		int time;
		int work;

		public Job(int time, int work) {
			this.time = time;
			this.work = work;
		}
	}

	public static int solution(int[][] jobs) {
		int answer = 0;
		PriorityQueue<Job> queue = new PriorityQueue<>(new Comparator<Job>() {
			@Override
			public int compare(Job o1, Job o2) {
				return o1.time - o2.time;
			}
		});

		for (int i = 0; i < jobs.length; i++) {
			queue.add(new Job(jobs[i][0], jobs[i][1]));
		}

		PriorityQueue<Job> scheduler = new PriorityQueue<>(new Comparator<Job>() {
			@Override
			public int compare(Job o1, Job o2) {				
				return o1.work - o2.work;
			}
		});
    
        int timer = 0;
        
		while (!queue.isEmpty()) {
			while (timer < queue.peek().time) {
				timer++;
			}
			while (!queue.isEmpty() && timer >= queue.peek().time) {
				scheduler.add(queue.poll());
			}
			while (!scheduler.isEmpty()) {
				Job j = scheduler.poll();
                timer += j.work;
				answer += timer - j.time;
				while (!queue.isEmpty() && timer >= queue.peek().time) {
					scheduler.add(queue.poll());
				}
//				System.out.println(timer + ":" +answer);
			}
		}

		return answer / jobs.length;
	}
}
