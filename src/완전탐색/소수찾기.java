package 완전탐색;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class 소수찾기 {

    static HashSet<Integer> numberSet = new HashSet<>();

    public static void main(String[] args) {
//        String numbers = "17";
        String numbers = "011";

        System.out.println(solution(numbers));
    }

    public static int solution(String numbers) {

        int answer = 0;

        recursive("", numbers);

        Iterator<Integer> iterator = numberSet.iterator();
        while (iterator.hasNext()) {
            int number = iterator.next();
            if(isPrime(number)) {
                answer++;
            }
        }

        return answer;
    }

    //숫자 만들어서 set에 넣기   , 모든 조합을 만드는 메서드
    public static void recursive(String comb, String others) {
         if(!comb.equals("")){
             numberSet.add(Integer.parseInt(comb));
         }

         for(int i = 0 ; i<others.length() ; i++){
             recursive(comb + others.charAt(i), others.substring(0, i) + others.substring(i+1));
         }


    }

    //소수 판단 메서드 추가
    public static boolean isPrime(int number) {
        if(number < 2) {
            return false;
        }

        for(int i = 2; i <= Math.sqrt(number); i++) {
            if(number % i == 0) { return false; }
        }

        return true;
    }
}
