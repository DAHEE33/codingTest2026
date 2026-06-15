package lv2;

public class 다음_큰_숫자 {

    public static void main(String[] args) {

        int n = 78;

        System.out.println(solution(n));
    }

    public static int solution(int n) {
//        int answer = 0;

        int targetCount = bitCount(bit(n));

        int next = n +1;
        while(true){
            int count = bitCount(bit(next));
            if(count == targetCount){
                return next;
            }
            next++;
        }

    }


    //2진법 만들기
    public static String bit(int n) {
        StringBuilder sb = new StringBuilder();

        while(n > 0){
          sb.append(n%2);
           n /= 2;
        }

        return sb.reverse().toString();
    }

    //2진법에서 숫자 '1' 세기
    public static int bitCount(String binary){
        int count = 0 ;
        for (int i = 0; i < binary.length(); i++) {
            if(binary.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
}
