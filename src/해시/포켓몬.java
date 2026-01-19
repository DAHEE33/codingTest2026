package 해시;

//N마리중 N/2마리 선택할 때 많은 종류의 포켓몬

import java.util.Arrays;

//만약 중복제거 후 >= N/2 면 이게 바로 가짓수 답
//만약 적다면 그냥 중복 제거하고 남은 수?
public class 포켓몬 {

    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2,2};

        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        int answer = 0;

        int[] result = Arrays.stream(nums).distinct().toArray();

        //HashSet 중복적으로 담을 수 있다 .

        if(result.length >= nums.length/2) {
            answer = nums.length/2;
        }else{
            answer = result.length;
        }
        return answer;
    }

}
