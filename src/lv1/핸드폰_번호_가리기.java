package lv1;

public class 핸드폰_번호_가리기 {

    public static void main(String[] args) {

        String phone_number = "01033334444";

        System.out.println(solution(phone_number));
    }

    public static String solution(String phone_number) {
        String answer = "";

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < phone_number.length() - 4; i++){
            sb.append("*");
        }

        for(int i = phone_number.length() - 4; i < phone_number.length(); i++){
            answer += phone_number.charAt(i);
        }

        answer = sb.toString() + answer;
        return answer;
    }
}
