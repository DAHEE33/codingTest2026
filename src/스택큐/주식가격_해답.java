package 스택큐;

import java.util.Stack;


public class 주식가격_해답 {

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};

        System.out.println(solution(prices));
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Integer> stack = new Stack<>();

        //넣는 시간 index
        for (int i = 0; i < prices.length; i++) {
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int index = stack.pop();
                answer[index] =  i - index;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            answer[index] = prices.length - 1 - index;
        }


        return answer;
    }


}
