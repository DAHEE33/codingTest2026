package lv2;

public class JadenCase_문자열_만들기 {

    public static void main(String[] args) {
        String s = "3people unFollowed me";

        System.out.println(solution(s));
    }

    public static String solution(String s) {

        StringBuilder sb = new StringBuilder();

        boolean isTure = true;
        for (int i = 0; i < s.length(); i++) {

            if(isTure) {
              sb.append(Character.toUpperCase(s.charAt(i)));
            }else{
                sb.append(Character.toLowerCase(s.charAt(i)));
            }


            if(s.charAt(i) == ' ') {
                isTure = true;
            }else {
                isTure = false;
            }
        }
        return sb.toString();
    }
}
