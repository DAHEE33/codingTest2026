package 정렬;

import java.util.Arrays;

/**
 * copyOfRange -> 끝 포함 X
 */
public class K번쨰수 {

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        System.out.println(solution(array,commands));
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
           int[] result = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
           Arrays.sort(result);
           answer[i] = result[commands[i][2] - 1];
        }
        return answer;
    }
}
