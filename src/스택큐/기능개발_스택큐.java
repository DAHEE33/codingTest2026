package 스택큐;

import java.util.*;

public class 기능개발_스택큐 {

    public static void main(String[] args) {
//        int[] progresses = {93, 30, 55};
//        int[] speeds = {1, 30, 5};

        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }

    public static int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> list = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            list.add((int)(Math.ceil((double)((100 - progresses[i]) / speeds[i]))));
        }

        ArrayList<Integer> ans = new ArrayList<>();

        while(!list.isEmpty()){

            int max = list.poll();
            int num = 1;

            while(!list.isEmpty() && list.peek() <= max){
                list.poll();
                num++;
            }

            ans.add(num);
        }

         return ans.stream().mapToInt(i -> i).toArray();
        

    }
}
