package lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class 카드뭉치 {

    public static void main(String[] args) {

        String[] cards1 = {"i", "drink", "water"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};

        System.out.println(solution(cards1,cards2,goal));
    }

    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "No";

        ArrayList<String> list1 = Arrays.stream(cards1)
                .collect(Collectors.toCollection(ArrayList::new));

        ArrayList<String> list2 = Arrays.stream(cards2).collect(Collectors.toCollection(ArrayList::new));

        int count = 0;
        for(String s : goal) {
            if(!list1.isEmpty() && s.equals(list1.get(0))) {
                count++;
                list1.remove(0);
            }else if(!list2.isEmpty() && s.equals(list2.get(0))) {
                count++;
                list2.remove(0);
            }else{
                answer = "No";
                break;
            }
        }

        if(count == goal.length) {
            answer = "Yes";
        }

        return answer;
    }
}
