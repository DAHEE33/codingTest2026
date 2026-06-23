package lv2;

import java.util.ArrayList;
import java.util.Arrays;

public class 영어_끝말잇기 {

    public static void main(String[] args) {

//        int n = 3;
//        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};

//        int n = 5;
//        String[] words = {"hello", "observe", "effect", "take", "either",
//                "recognize", "encourage", "ensure", "establish", "hang",
//                "gather", "refer", "reference", "estimate", "executive"};

        int n = 2;
        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};

//        System.out.println(solution(n, words));

        // 1. 결과값을 변수에 먼저 담습니다.
        int[] result = solution(n, words);

        // 2. Arrays.toString()으로 감싸서 출력합니다.
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(int n, String[] words) {

        ArrayList<String> list = new ArrayList<>();

        int number = 1;
        int order = 1;

        int cnt = 0;

        boolean isFalse = false;
        for(int i = 0; i < words.length-1; i++){

            if(list.contains(words[i])){ // 그 number, order
                isFalse = true;
                break;
            }

            if(words[i].charAt(words[i].length()-1) == words[i+1].charAt(0)){
                list.add(words[i]);
            }else{ // 다음 number , order
                number++;

                if(number > n){
                    number = 1;
                    order ++;
                }

                isFalse = true;
            }

            if(isFalse) break;

            number++;

            if(number > n){
                number = 1;
                order ++;
            }

            cnt++;
        }

        if(list.contains(words[words.length-1])) {

            if(number > n){
                number = 1;
                order ++;
            }

            return new int[]{number, order};
        }

        if(!(isFalse) && cnt == words.length-1) return new int[]{0,0};

        return new int[]{number, order};
    }
}
