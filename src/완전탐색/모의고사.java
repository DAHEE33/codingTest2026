package 완전탐색;

import java.util.ArrayList;

public class 모의고사 {

    public static void main(String[] args) {
        int[] answers = {1,2,3,4,5};

        System.out.println(solution(answers));
    }

    public static int[] solution(int[] answers) {

        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] score = new int[3];

        //indexOfBoundException 처리
        for (int i = 0; i < answers.length; i++) {
            if(answers[i] == a[i%a.length]) {score[0]++;}
            if(answers[i] == b[i%b.length]) {score[1]++;}
            if(answers[i] == c[i%c.length]) {score[2]++;}
        }

        int max = Math.max(score[0], Math.max(score[1], score[2]));

        ArrayList<Integer> list = new ArrayList<>();
        if (max == score[0]) { list.add(1); }
        if (max == score[1]) { list.add(2); }
        if (max == score[2]) { list.add(3); }

        return list.stream().mapToInt(i -> i).toArray();

    }
}
