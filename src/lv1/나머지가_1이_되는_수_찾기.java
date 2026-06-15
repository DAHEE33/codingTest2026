package lv1;

public class 나머지가_1이_되는_수_찾기 {

    public static void main(String[] args) {
        int n = 12;

        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int answer = n-1;

        for (int i = n-2; i >= 2; i--) {
            if(n % i == 1){
                answer = i;
            }
        }
        return answer;
    }
}
