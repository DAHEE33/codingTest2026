package 스택큐;

import java.util.LinkedList;
import java.util.Queue;

public class 프로세스 {
    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;

        System.out.println(solution(priorities,location));
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<PriorityQueue> queues = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queues.offer(new PriorityQueue(i, priorities[i]));
        }

        while (!queues.isEmpty()) {
            PriorityQueue queue = queues.poll();

            boolean hasBigger = false;
            for (PriorityQueue q : queues) {
                if(q.priority > queue.priority){
                    hasBigger = true;
                    break;
                }
            }

            if(hasBigger){
                queues.offer(queue);
            }else{
                answer++;

                if(queue.location == location){
                    return answer;
                }
            }
        }
        return answer;
    }

    public static class PriorityQueue {
        int location;
        int priority;

        public PriorityQueue(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }
    }
}
