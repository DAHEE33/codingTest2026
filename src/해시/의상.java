package 해시;

import java.util.HashMap;

public class 의상 {
    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        System.out.println(solution(clothes));
    }


    public static int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();

        for (String[] clothe : clothes) {
            map.put(clothe[1], map.getOrDefault(clothe[1], 0 )+1);
        }

        for(String key : map.keySet()) {
            answer *= (map.get(key)+1);
        }

        return answer-1;
    }

}
