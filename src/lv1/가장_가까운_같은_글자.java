package lv1;

public class 가장_가까운_같은_글자 {

    public static void main(String[] args) {

        String s = "banana";

        System.out.println(solution(s));
    }

    public static int[] solution(String s) {
        int[] answer = new int[s.length()];

        for ( int i = s.length() - 1; i >= 0; i-- ) {
            char s_ch = s.charAt(i);
            for ( int j = i - 1; j >= 0; j-- ) {
                char e_ch = s.charAt(j);

                if(s_ch == e_ch) {
                    answer[i] = i - j;
                    break;
                }
            }
            if(answer[i] == 0){
                answer[i] = -1;
            }
        }

        return answer;
    }
}
