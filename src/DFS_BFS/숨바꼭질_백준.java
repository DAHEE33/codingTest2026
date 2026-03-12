package DFS_BFS;

import org.w3c.dom.css.CSSUnknownRule;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 숨바꼭질_백준 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(solution(n, k));
    }

    public static int solution(int n, int k) {
        if (n == k) return 0;

        int[] visited = new int[100001];

        Queue<Integer> queue = new LinkedList<>();

        queue.add(n);
        visited[n] = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == k) {
                return visited[cur] - 1;
            }

            int[] nextList = {cur + 1, cur - 1, cur * 2};
            for (int i : nextList) {
                if (i >= 0 && i <= 100000) {

                    if (visited[i] == 0) {
                        queue.add(i);
                        visited[i] = visited[cur] + 1;
                    }
                }
            }
        }


        return -1;

    }

}
