package lv2;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *  Queue
 *  1. offer : 값넣기
 *  2. poll : 값빼기
 *  3. peek : 값보기
 *
 *  Stack
 *  1. push : 값넣기
 *  2. pop : 값빼기
 *  3. peek : 값보기 --> 비어있는지 확인할 것
 */
public class 괄호_회전하기 {

    public static void main(String[] args) {

//        String s = "[](){}";
//        String s = "}]()[{";
        String s = "}}}";

        System.out.println(solution(s));
    }

    public static int solution(String s) {
        int answer = 0;

        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            queue.offer(s.charAt(i));
        }

        for(int i = 0; i < s.length(); i++){
            // queue 가 계속 회전 ..
            if(check(new LinkedList<>(queue)) == 1){
                answer++;
            }
            queue.offer(queue.poll());
        }

        return answer;
    }

    public static int check(Queue<Character> queue){

        int check_result = 0;

        Stack<Character> stack = new Stack<>();

        //일단 처음은 값 push
        stack.push(queue.poll());
        int size = queue.size();

        //queue size가 변하기 떄문에 고정적인 길이로 진행해야함
        for(int i = 0; i < size; i++){

            if(!stack.isEmpty() && ((queue.peek() == '}' && stack.peek() == '{') || (queue.peek() == ']' && stack.peek() == '[') || (queue.peek() == ')' && stack.peek() == '('))){
                queue.poll();
                stack.pop();
            }else{
                stack.push(queue.poll());
            }
        }
        if(stack.isEmpty()){check_result = 1;}

        return check_result;

    }











}


