package DFS_BFS;

public class 네트워크 {

    public static int answer = 0;

    public static void main(String[] args) {
        int[][] computer = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        int n = 3;

        System.out.println(solution(n, computer));
    }

    public static int solution(int n, int[][] computer) {

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i, n, computer, visited);
                answer++;
            }
        }
        return answer;
    }

    public static void dfs(int node, int n, int[][] computer, boolean[] visited) {

        // 방문하게 되면  true 처리
        visited[node] = true;

        for (int i = 0; i < n; i++) {
            // 만약 방문이 안되어있고, computer가 1이라면 처리해
            if(computer[node][i] == 1 && !visited[i]) {
                dfs(node, i, computer, visited);
            }
        }
    }
}
