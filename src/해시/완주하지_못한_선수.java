package 해시;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 완주하지_못한_선수 {

    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"kiki", "eden"};

        System.out.println(solution(participant, completion));
    }

    //문제 효율성에서 떨어짐
//    public static String solution(String[] participant, String[] completion) {
//        String answer = "";
//
//        List<String> list = new ArrayList<String>(Arrays.asList(participant));
//
//        for (String s : completion) {
//            if(list.contains(s)){
//                //remove 할때마다 shift 비용 고려
//                list.remove(s);
//            }
//        }
//
//        answer = list.get(0);
//
//        return answer;
//    }

    //HashMap 이용
//    public static String solution(String[] participant, String[] completion) {
//        String answer = "";
//
//        HashMap<String, Integer> map = new HashMap<>();
//
//        for (String s : participant) {
//            map.put(s, map.getOrDefault(s, 0) + 1);
//        }
//
//        for (String s : completion) {
//            map.put(s, map.get(s) - 1);
//        }
//
//        for (String s : map.keySet()) {
//            if (map.get(s) != 0) { answer = s;}
//        }
//
//
//        return answer;
//    }

    //Arrya 정렬 이용
    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i = 0; i < completion.length; i++) {
            if(!participant[i].equals(completion[i])) {
                answer = participant[i];
            }
        }

        if(answer.equals("")) {
            answer = participant[participant.length - 1];
        }


        return answer;
    }


}
