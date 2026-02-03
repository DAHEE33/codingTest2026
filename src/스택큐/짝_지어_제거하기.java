package 스택큐;

import java.util.Stack;

public class 짝_지어_제거하기 {

    public static void main(String[] args) {
        String s = "cdcd";

        System.out.println(solution(s));
    }

    public static int solution(String s)
    {
        int answer = 0;

        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(!stack.isEmpty() && stack.peek() == chars[i]){
                stack.pop();
            }else {
                stack.push(chars[i]);
            }
        }

        if(stack.isEmpty()){answer = 1;}


        return answer;
    }
}
