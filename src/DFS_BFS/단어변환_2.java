package DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

//공용 숫자 주의

public class 단어변환_2 {

    public static void main(String[] args) {
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        String begin = "hit";
        String target = "cog";

        System.out.println(solution(begin, target, words));
    }

    public static int solution(String begin, String target, String[] words) {
        int answer = 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(begin);

        boolean[] visited = new boolean[words.length];

        while(!queue.isEmpty()) {

            int cnt = queue.size();
            String word = queue.poll();

            if(word.equals(target)) {
                return answer;
            }

            for(int i = 0; i < words.length; i++) {
                if(visited[i] == false && isCompare(words[i], word)) {
                    visited[i] = true;

                    queue.add(words[i]);
                }
            }
            answer++;
        }

        return answer;
    }

    public static boolean isCompare(String s1, String s2){
        if(s1.length() != s2.length()){return false;}

        int diff = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){diff++;}
        }
        if(diff == 1){return true;}
        return false;
    }

}
