package DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵_최단거리 {
    public static void main(String[] args) {
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};


        System.out.println(solution(maps));
    }

    public static int solution(int[][] maps) {
        int answer = 0;

        boolean[][] visited = new boolean[maps.length][maps[0].length];

        //x,y 별로 queue 값 만들기
        Queue<Integer> queueX = new LinkedList<>();
        Queue<Integer> queueY = new LinkedList<>();

        // 시작점 0,0 넣기
        queueX.add(0);
        queueY.add(0);

        visited[0][0] = true;

        int[] dx = {-1, 1, 0 ,0};
        int[] dy = {0, 0, -1, 1};

        while(!queueX.isEmpty() && !queueY.isEmpty()) {
            int x = queueX.poll();
            int y = queueY.poll();

            //for문 dx, dy 돌리기
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length) {
                    //만약 이 값들이 1이고 방문한 적이 없다면 queue에 넣고 좌표를 ++ 해준다..
                    if (maps[nx][ny] == 1 && visited[nx][ny] == false) {
                        visited[nx][ny] = true;

                        queueX.add(nx);
                        queueY.add(ny);

                        maps[nx][ny] = maps[x][y] + 1;
                    }
                }
            }
        }

        answer = maps[maps.length - 1][maps[0].length - 1];

        if(answer == 1) answer = -1;

        return answer;
    }
}
