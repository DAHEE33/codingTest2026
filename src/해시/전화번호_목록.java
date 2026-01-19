package 해시;

import java.util.Arrays;

public class 전화번호_목록 {

    public static void main(String[] args) {
        String[] phone_book = {"12","123","1235","567","88"};

        System.out.println(solution(phone_book));
    }


    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        //효율성 테스트~~ 또 떨어졌어~~
        // 길이순일 때는 전체 다 비교
//        Arrays.sort(phone_book, (s1, s2) -> s1.length() - s2.length());
//
//        for(int i = 0; i < phone_book.length; i++) {
//            for(int j = i+1; j < phone_book.length; j++) {
//                if(phone_book[j].startsWith(phone_book[i])) {
//                    answer = false;
//                }
//            }
//        }

        //사전순
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length-1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i])){
                answer = false;
            }
        }


        return answer;
    }
}
