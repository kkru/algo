package Programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<Job> pq = new PriorityQueue<>();
        List<Job> list = new ArrayList<>();

        for (int i = 0; i < jobs.length; i++) {
            pq.add(new Job(jobs[i][0], jobs[i][1]));
        }

        for (int i = 0; i < jobs.length; i++) {
            list.add(pq.poll());
        }

        int time = 0;
        int sum = 0;
        while (list.size()>0) {
            for (int i = 0; i < list.size(); i++) {
                if (time>=list.get(i).start) {
                    time+=list.get(i).work;
                    sum+=time-list.get(i).start;
                    list.remove(i);
                    break;
                }
                if (i == list.size()-1) time++;
            }
        }

        int answer = (sum/jobs.length);
        return answer;
    }
}

class Job implements Comparable<Job> {
    int start;
    int work;

    public Job(int start, int work){
        this.start = start;
        this.work = work;
    }

    @Override
    public int compareTo(Job o){
        if(this.work < o.work)
            return -1;
        else if(this.work == o.work){
            if(this.start < o.start)
                return -1;
            else
                return 1;
        }
        else 
            return 1;
    }
}