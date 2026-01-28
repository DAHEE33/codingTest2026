package 스택큐;

import java.util.LinkedList;
import java.util.Queue;

//전체 숫자 100 미만 -> O(N) 이용해도 됨
public class 프로세스_해답 {

    public static void main(String[] args) {
         int[] priorities = {2, 1, 3, 2};
         int location = 2;

        System.out.println(solution(priorities,location));
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        //queue와 LinkedList는 함께 결합하여 알아두기
        Queue<PrinterJob> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            //큐 뒤에 데이터를 넣는다. offer - poll / add - remove
            queue.offer(new PrinterJob(i, priorities[i]));
        }


        while (!queue.isEmpty()) {
            PrinterJob currentJob = queue.poll();

            boolean isHigherExist = false;
            for(PrinterJob printerJob1 : queue) {
                if(printerJob1.priority > currentJob.priority) {
                    isHigherExist = true;
                    break;
                }
            }

            if(isHigherExist){
                queue.offer(currentJob);
            }else{
               answer++;

               if(currentJob.location == location) {
                   return answer;
               }
            }
        }

        return answer;
    }

    //중요도에 따른 위치는 고유해야한다.
    public static class PrinterJob {
        int location;
        int priority;

        public PrinterJob(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }
    }
}
