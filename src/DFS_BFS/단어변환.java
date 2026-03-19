package DFS_BFS;

import java.util.*;

/**
 * "hit"	"cog"	["hot", "dot", "dog", "lot", "log", "cog"]	4
 * "hit"	"cog"	["hot", "dot", "dog", "lot", "log"]	0
 */
public class 단어변환 {

    static class Node {
        String word;
        int edge;

        public Node(String word, int edge) {
            this.word = word;
            this.edge = edge;
        }
    }

    public static void main(String[] args) {
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        String begin = "hit";
        String target = "cog";

        System.out.println(solution(begin, target, words));
    }

    public static int solution(String begin, String target, String[] words) {

        List<String> wordList = new ArrayList<>(Arrays.asList(words));

        if(!wordList.contains(target)){return 0;}

        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];

        queue.add(new Node(begin, 0));

        while(!queue.isEmpty()){
            Node curr = queue.poll();

            if(curr.word.equals(target)){
                return curr.edge;
            }

            for(int i = 0; i < wordList.size(); i++){
                if(!visited[i] && isOneCharDiff(curr.word, words[i])){
                    visited[i] = true;
                    queue.add(new Node(words[i], curr.edge+1));
                }
            }
        }

        return 0;
    }

    private static boolean isOneCharDiff(String s1, String s2) {
        int diffCount = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCount++;
            }
            if (diffCount > 1) return false;
        }
        return diffCount == 1;
    }


}
