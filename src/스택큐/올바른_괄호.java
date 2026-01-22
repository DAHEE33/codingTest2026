package 스택큐;

import java.util.Stack;

public class 올바른_괄호 {

    public static void main(String[] args) {

        String s =  "()()";

        System.out.println(solution(s));
    }


    static boolean solution(String s) {
        boolean answer = true;

        char[] chars = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(chars[i]);
            }
            else if (chars[i] == ')' & !stack.empty()) {
                stack.pop();
            }else{
                answer = false;
            }
        }

        if(!stack.isEmpty()){
            answer = false;
        }
        return answer;
    }
}
