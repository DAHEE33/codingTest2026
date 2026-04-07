package 완전탐색;

public class 카펫 {

    public static void main(String[] args) {

//        int brown = 10;
//        int yellow = 2;

//        int brown = 8;
//        int yellow = 1;
        int brown = 24;
        int yellow = 24;

        System.out.println(solution(brown, yellow));
    }

    //가로 길이 >= 세로 길이
    //brown 색과 yellow 색의 개수를 보고 [가로,세로] 길이 유추
    public static int[] solution(int brown, int yellow) {

        int a = 0; //가로
        int b = 0; //세로

        //i = 세로
        for (int i = 1; i < (brown+yellow)/2 ; i++) {
            int num1 = brown/2 - 2 - i;
            int num2 = yellow/i;
            if(num1 == num2 && num1 > 0 && num2 > 0 && (num1 + 2) * (i + 2) == (brown + yellow)) {
                a = i + 2;
                b = num1 + 2;
            }
        }

        int[] answer = {a, b};

        return answer;
    }
}
