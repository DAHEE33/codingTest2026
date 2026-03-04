package 정렬;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * 내림차순
 * 1. 객체 Arrays.sort(arr, Collections.reverseOrder());
 * 2.  int 1) 오른차순을 for문에서 반대로 받기 2.Stream 이용
 */
public class Hindex {

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};

        System.out.println(solution(citations));
    }


    public static int solution(int[] citations) {
        int answer = 0;

        //내림차순
//        citations = Arrays.stream(citations).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();

        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
          int h = citations[i];
          int count = 0;
          for (int j = i ; j < citations.length; j++) {
              if (citations[j] >= h) {
                  count++;
              }
          }
          if ( h >= count){
              answer = count;
              break;
          }
        }

        return answer;
    }
}
