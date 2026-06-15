package lv2;

import java.util.ArrayList;
import java.util.HashMap;

public class 귤_고르기 {

    public static void main(String[] args) {

//        int k = 6;
//        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};

        int k = 4;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};

//        int k = 6;
//        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};

        System.out.println(solution(k, tangerine));
    }

    public static int solution(int k, int[] tangerine) {
        int answer = 0;

        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList(map.values());

        list.sort((a, b) -> b - a);

        int count = 0;
        for( int num : list ) {
            count += num;
            answer++;

            if(count >= k){
                break;
            }
        }


        return answer;
    }
}
