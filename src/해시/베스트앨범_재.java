package 해시;

import java.util.*;

/**
 * 단독으로 쓰일 Collections.sort() 의 경우 오름차순
 * 객체로 쓰일 경우 comparable implements 하여 사용
 * 객체는 기준으로 정해줘야함
 */
public class 베스트앨범_재 {

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};

        int[] plays = {500, 600, 150, 800, 2500};

        System.out.println(solution(genres, plays));
    }

    //Music에 대한 내부 클래스 생성하기
    static class Music implements Comparable<Music> {
        int id;
        int play;
        public Music(int id, int play) {
            this.id = id;
            this.play = play;
        }

        @Override
        public int compareTo(Music o) {
            //Collections 함수를 쓰기 위해 Comparable implements 받음
            if(this.play != o.play){
                return o.play - this.play;
            }

            // 재생 횟수가 같은 경우 id 오름차순
            return this.id - o.id;
        }


    }

    public static int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> genrePlayCount = new HashMap<>();

        Map<String, List<Music>> genreMusic = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            genrePlayCount.put(genre, genrePlayCount.getOrDefault(genre, 0) + 1);

            //없다면 배열을 만들어서 music 값을 담아야하는데..
            genreMusic.computeIfAbsent(genre, k -> new ArrayList<>()).add(new Music(i,play));
        }

        // 장르가 가장 높은 2개와
        // 각 장르별 play수가 높은 것 .. genreMusic sort
        List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
        // value의 내림차순으로 정렬
        sortedGenres.sort((a,b)-> genrePlayCount.get(b) - genrePlayCount.get(a));


        List<Integer> ans = new ArrayList<>();

        for(String genre : sortedGenres){
            //해당 장르의 music 가져와
            List<Music> musics = genreMusic.get(genre);

            // 재생수가 같은경우 id 오름차순
            Collections.sort(musics);

            int count = 0;
            for(Music music : musics){
                ans.add(music.id);
                count++;
                if(count >= 2) break;
            }

        }

//        return ans.stream().mapToInt(i->i).toArray();


        // 스트림 대신 이렇게 써도 100점입니다.
        int[] result = new int[ans.size()]; // 크기 딱 맞는 배열 만들고

        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i); // 하나씩 꺼내서 옮겨 담기
        }

        return result;
    }
}
