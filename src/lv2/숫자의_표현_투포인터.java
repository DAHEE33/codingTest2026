package lv2;

public class 숫자의_표현_투포인터 {

    public static void main(String[] args) {

        int n = 15;

        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int answer = 0;

        int start = 1;
        int end = 1;
        int sum = 1;

        while(start <= n){

            if(sum < n){
                end++;
                sum += end;
            }else if(sum > n){
                sum -= start;
                start++;
            }

            if(sum == n){
                answer++;
                sum -= start;
                start++;
            }

        }

        return answer;
    }
}
