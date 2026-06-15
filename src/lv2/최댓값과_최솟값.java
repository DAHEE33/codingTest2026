package lv2;

public class 최댓값과_최솟값 {

    public static void main(String[] args) {
//        String s = "1 2 3 4";
        String s = "-1 -2 -3 -4";
//        String s = "-1 -1";

        System.out.println(solution(s));
    }

    public static String solution(String s) {
//        String answer = "";

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        String[] arr = s.split(" ");

        for(String str : arr) {
            int num = Integer.parseInt(str);

            if(num < min) min = num;
            if(num > max) max = num;
        }


        return min + " " + max;
    }
}
