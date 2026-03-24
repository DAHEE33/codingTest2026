package DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 최단 거리 - > BFS
 * queue 이용
 * visited
 *
 * 아무것도 최단 거리가 없다면 -1
 *
 * visited 배열로 값을 처리
 *
 */
public class 게임맵_최단거리_2 {
    public static void main(String[] args) {
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};


        System.out.println(solution(maps));
    }

    public static int solution(int[][] maps) {
        int answer = 0;

        boolean[][] visited = new boolean[maps.length][maps[0].length];

        Queue<Integer> queueX = new LinkedList<>();
        Queue<Integer> queueY = new LinkedList<>();

        queueX.add(0);
        queueY.add(0);

        visited[0][0] = true;

        maps[0][0] = 1;

        int[] qx = {1, -1, 0, 0};
        int[] qy = {0, 0, 1, -1};

        while(!queueX.isEmpty() && !queueY.isEmpty()) {
            int nx = queueX.poll();
            int ny = queueY.poll();

            for(int i = 0; i < 4; i++) {
                int x = nx + qx[i];
                int y = ny + qy[i];

                if(x >= 0 && x < maps.length && y >= 0 && y < maps[0].length) {
                    if(maps[x][y] == 1 && visited[x][y] == false) {
                        visited[x][y] = true;

                        queueX.add(x);
                        queueY.add(y);

                        maps[x][y] = maps[nx][ny] + 1;
                    }
                }
            }
        }


        answer = maps[maps.length - 1][maps[0].length - 1];

        //while문의 조건에 의해, 막다른 길이라면 그대로 nx든 ny든 증가없이 종료 -> 막다른길
        if(answer == 1) answer = -1;


        return answer;
    }
}
