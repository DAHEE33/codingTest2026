package DFS_BFS;

public class 타겟넘버 {

    static int answer = 0;
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};

        int target = 3;


        System.out.println(solution(numbers, target));
    }

    public static int solution(int[] numbers, int target) {


        dfs(0,0,numbers,target);

        return answer;
    }

    //인덱스, 전체수, 배열, 타겟넘버
    public static void dfs(int n, int total, int[] numbers, int target) {

        if(n == numbers.length) {
            if(total == target) {
                answer++;
            }
            return;
        }

        dfs(n+1, total + numbers[n], numbers, target);
        dfs(n+1, total - numbers[n], numbers, target);


    }
}
