package 스택큐;

import java.util.Stack;

public class 뒤에_있는_큰_수_찾기 {

    public static void main(String[] args) {
        int[] numbers = {2, 3, 3, 5};

        System.out.println(solution(numbers));
    }

    public static int[] solution(int[] numbers) {
        int[] ans = new int[numbers.length];

        Stack<priority> stack = new Stack<>();

        for (int i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty() && stack.peek().num < numbers[i]) {
                ans[stack.pop().i] = numbers[i];
            }
            stack.push(new priority(i, numbers[i]));
        }

        while (!stack.isEmpty()) {
            ans[stack.pop().i] = -1;
        }

        return ans;

    }

    public static class priority {
        int i ;
        int num ;

        public priority(int i, int num) {
            this.i = i;
            this.num = num;
        }
    }
}
