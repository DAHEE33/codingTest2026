package lv1;

public class 문자열을_정수로_바꾸기 {

    public static void main(String[] args) {
        String s = "-1234";

        System.out.println(solution(s));
    }

    public static int solution(String s) {

        return Integer.parseInt(s);
    }
}
