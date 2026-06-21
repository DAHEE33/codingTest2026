package lv2;

import java.util.ArrayList;

public class 영어_끝말잇기 {

    public static void main(String[] args) {

        int n = 5;
        String[] words = {"hello", "observe", "effect", "take", "either",
                "recognize", "encourage", "ensure", "establish", "hang",
                "gather", "refer", "reference", "estimate", "executive"};

        System.out.println(solution(n, words));
    }

    public static int[] solution(int n, String[] words) {

        ArrayList<String> list = new ArrayList<>();

        int number = 0;
        int order = 1;

        int cnt = 0;
        for(int i = 0; i < words.length-1; i++){
            number++;

            if(list.contains(words[i])){
                break;
            }

            if(words[i].charAt(words[i].length()-1) == words[i+1].charAt(0)){
                list.add(words[i]);
            }else{
                if(number == n){
                    number = 1;
                    order ++;
                }
                break;
            }

            if(number == n){
                number = 0;
                order ++;
            }
            cnt++;
        }

        if(list.contains(words[words.length-1])) return new int[]{number+1, order};

        if(cnt == words.length-1) return new int[]{0,0};

        return new int[]{number, order};
    }
}
