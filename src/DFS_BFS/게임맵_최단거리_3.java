package DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 최단거리 -> BFS
 * Queue 이용
 */
public class 게임맵_최단거리_3 {

    public static void main(String[] args) {
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};


        System.out.println(solution(maps));
    }


    public static int solution(int[][] maps) {
        int answer = 0;

        //방문 여부 기록
        boolean[][] visited = new boolean[maps.length][maps[0].length];

        //좌표 생성
        int[] nx = {1, -1, 0, 0};
        int[] ny = {0, 0, 1, -1};

        //Queue 생성
        Queue<Integer> queueX = new LinkedList<>();
        Queue<Integer> queueY = new LinkedList<>();

        queueX.offer(0);
        queueY.offer(0);

        maps[0][0] = 1;

        while (!queueX.isEmpty() && !queueY.isEmpty()) {
            int qx = queueX.poll();
            int qy = queueY.poll();

            for (int i = 0; i < 4; i++) {
                int x = qx + nx[i];
                int y = qy + ny[i];

                //if절 범위
                if ( x >= 0 && x < maps.length && y >= 0 && y < maps[0].length) {
                    if(maps[x][y] == 1 && visited[x][y] == false) {
                        visited[x][y] = true;

                        queueX.add(x);
                        queueY.add(y);

                        maps[x][y] = maps[qx][qy] + 1;

                    }
                }
            }
        }

        answer = maps[maps.length - 1][maps[0].length - 1];

        if (answer == 1) {
            answer = -1;
        }

        return answer;
    }
}
