package 완전탐색;

public class 피로도 {

    static int MaxDepth = 0;
    public static void main(String[] args) {
        int[][] dungeons = {{80,20},{50,40},{30,10}};
        int k = 80;

        System.out.println(solution(k, dungeons));
    }

    public static int solution(int k, int[][] dungeons) {

        boolean[] visited = new boolean[dungeons.length];

        int depth = 0;
        check(k,depth,dungeons,visited);

        return MaxDepth;
    }

    public static void check(int k, int depth, int[][] dungeons, boolean[] visited) {
        MaxDepth = Math.max(MaxDepth, depth);
        for ( int i = 0; i < dungeons.length; i++ ) {
           if(visited[i] == false && dungeons[i][0] <= k) {
               visited[i] = true;

               // k와 depth를 직접 수정하지 않고, 인자로 계산해서 넘김 -> 이 for문이 다음 i를 돌 때 원본 k와 depth가 유지
               check(k - dungeons[i][1], depth + 1, dungeons, visited);

               visited[i] = false;
           }
        }
    }
}
