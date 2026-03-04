package 정렬;

import java.util.Arrays;

/**
 * compareTo
 * 1. 객체비교 int는 안되고 String, Integer과 같은 객체 타입
 * 2, 문자열 사전순 정렬
 * 3. 우선순위 큐 설정
 *
 * (a,b) -> a.compareTo.b : 오름차순 반대는 내림차순
 *
 */
public class 가장_큰_수 {
    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};

        System.out.println(solution(numbers));
    }

    public static String solution(int[] numbers) {
        String answer = "";

        String[] str = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(str, (a,b) -> (b+a).compareTo(a+b));

        /**
         * 0일때 부분 추가
         *
         */
        if (str[0].equals("0")) {
            return "0";
        }

        for (int i = 0; i < str.length; i++) {
            answer += str[i];
        }



        return answer;
    }
}
