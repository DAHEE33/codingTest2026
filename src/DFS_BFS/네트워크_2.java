package DFS_BFS;

public class 네트워크_2 {

    /**
     * DFS
     * Boolean visited
     * 계속 self 파고 듦
     *
     * n*n 정사각형 computers 배열
     * 현재 노트, 전체 개수, 배열, 방문기록
     *
     */
    public static int answer = 0;

    public static void main(String[] args) {
//        int[][] computer = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}; //2
        int[][] computer = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}; //1

        int n = 3;

        System.out.println(solution(n, computer));
    }

    public static int solution(int n, int[][] computer) {

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                dsf(i, n, computer, visited);
                answer += 1;
            }
        }

        return answer;
    }

    public static void dsf(int i, int n, int[][] computer, boolean[] visited) {
        visited[i] = true;

        for(int j=0;j<n;j++){
            if(computer[i][j]==1 &&  !visited[j]){
                dsf(j,n,computer,visited);
            }
        }
    }



}
