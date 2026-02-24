package 완전탐색;

import java.util.Arrays;

public class 최소직사각형 {
    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};

        System.out.println(solution(sizes));
    }

    public static int solution(int[][] sizes) {
        int answer = 0;

        int max_x = 0;
        int max_y = 0;
//
//        for (int i = 0; i < sizes.length; i++) {
//            Arrays.sort(sizes[i]);
//
//            if (max_x < sizes[i][0]) {
//                max_x = sizes[i][0];
//            }
//
//            if (max_y < sizes[i][1]) {
//                max_y = sizes[i][1];
//            }
//        }

        for (int[] size : sizes) {
            max_x = Math.max(max_x, Math.max(size[0], size[1]));
            max_y = Math.max(max_y, Math.min(size[0], size[1]));
        }
        answer = max_x * max_y;
        return answer;
    }
}
