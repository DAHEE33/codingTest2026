package 스택큐;

import java.util.Stack;

public class 큰_수_만들기 {

    public static void main(String[] args) {
        String number = "1231234";
        int k =3;

        System.out.println(solution(number, k));
    }


    public static String solution(String number, int k) {


        Stack<Character> stack = new Stack<>();

        char[] arr = number.toCharArray();

        for (int i = 0; i < arr.length; i++) {

            while(!stack.empty() && stack.peek() < arr[i] && k>0) {
                stack.pop();
                k--;
            }
            stack.push(arr[i]);

        }

        //전체 내림차순인 경우
        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
