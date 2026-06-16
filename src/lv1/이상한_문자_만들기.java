package lv1;

public class 이상한_문자_만들기 {

    public static void main(String[] args) {
        String s = "try hello world";

        System.out.println(solution(s));
    }

    public static String solution(String s) {
//        String answer = "";

        StringBuilder sb = new StringBuilder();

        int index = 0;
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if(ch == ' '){
                sb.append(' ');
                index = 0;
            }else{
                if(index % 2 == 0){
                    sb.append(Character.toUpperCase(ch));

                }else {
                    sb.append(Character.toLowerCase(ch));
                }
                index++;
            }
        }

        return sb.toString();
    }
}
