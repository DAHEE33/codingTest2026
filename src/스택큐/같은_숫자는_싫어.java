package 스택큐;

import java.util.Arrays;
import java.util.Stack;

public class 같은_숫자는_싫어 {

    public static void main(String[] args) {
        int[] arr = {1,1,3,3,0,1,1};

        System.out.println(Arrays.toString(solution(arr)));
    }

    public static int[] solution(int []arr) {

        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i-1]) {
                stack.push(arr[i]);
            }
        }

        int[] answer = new int[stack.size()];
        for(int i = stack.size()-1; i >= 0; i--) {
            answer[i] = stack.pop();
        }
        return answer;
    }
}
