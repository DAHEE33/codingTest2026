package DFS_BFS;

public class 네트워크_3 {

    public static void main(String[] args) {
        int[][] computer = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        int n = 3;

        System.out.println(solution(n, computer));
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
           if(!visited[i]){
               network(i,n,computers,visited);
               answer++;
           }


        }
        return answer;
    }

    public static void network(int node, int n, int[][] computers, boolean[] visited) {
        visited[node] = true;

        for (int i = 0; i < n; i++) {
            if(computers[node][i] == 1 && !visited[i]) {
                network(i, n, computers, visited);
            }
        }

    }
}
