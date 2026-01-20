package 스택큐;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class 기능개발 {

    public static void main(String[] args) {
//        int[] progresses = {93, 30, 55};
//        int[] speeds = {1, 30, 5};

        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }

    public static int[] solution(int[] progresses, int[] speeds) {


        int[] temp = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            int days = remain / speeds[i];

            if(remain % speeds[i] != 0) {days += 1;}

            temp[i] = days;
        }

        int num = 1;

        int max = temp[0];
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < temp.length-1; i++) {

            if(max < temp[i+1]){

                list.add(num);
                max = temp[i+1];
                num=1;
            }else {
                num++;
            }

        }

        list.add(num);


        return list.stream().mapToInt(i->i).toArray();

    }

}
