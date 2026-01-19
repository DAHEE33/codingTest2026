package 해시;

import java.util.*;

public class 베스트앨범 {

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};

        int[] plays = {500, 600, 150, 800, 2500};

        System.out.println(solution(genres, plays));
    }

    // 곡 정보를 담을 클래스 (Comparable을 구현해서 정렬 기준 정의)
    static class Music implements Comparable<Music> {
        int id;
        int play;

        public Music(int id, int play) {
            this.id = id;
            this.play = play;
        }

        @Override
        public int compareTo(Music other) {
            // 1. 재생 횟수가 많은 순 (내림차순)
            if (this.play != other.play) {
                return other.play - this.play;
            }
            // 2. 재생 횟수가 같으면 고유 번호가 낮은 순 (오름차순)
            return this.id - other.id;
        }
    }

    public static int[] solution(String[] genres, int[] plays) {
        // 1. 장르별 총 재생 횟수 저장 (장르 순위용)
        Map<String, Integer> genrePlayCount = new HashMap<>();

        // 2. 장르별 곡 리스트 저장 (곡 선정용)
        Map<String, List<Music>> genreMusics = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            // 장르별 총 재생 수 누적
            genrePlayCount.put(genre, genrePlayCount.getOrDefault(genre, 0) + play);

            // 해당 장르 리스트에 곡 추가
            genreMusics.computeIfAbsent(genre, k -> new ArrayList<>()).add(new Music(i, play));
        }

        // 3. 장르 선정 (총 재생 횟수가 높은 순으로 장르 정렬)
        List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
        sortedGenres.sort((a, b) -> genrePlayCount.get(b) - genrePlayCount.get(a));

        // 4. 결과 담기
        List<Integer> answerList = new ArrayList<>();

        for (String genre : sortedGenres) {
            // 해당 장르의 곡 리스트 가져오기
            List<Music> musics = genreMusics.get(genre);

            // 곡 정렬 (Comparable 기준)
            Collections.sort(musics);

            // 상위 2개까지만 뽑기 (곡이 1개면 1개만)
            int count = 0;
            for (Music music : musics) {
                answerList.add(music.id);
                count++;
                if (count >= 2) break;
            }
        }

        // List -> int[] 변환
        return answerList.stream().mapToInt(i -> i).toArray();
    }
}

