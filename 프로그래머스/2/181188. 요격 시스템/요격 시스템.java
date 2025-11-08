import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        // 꼬리를 기준으로 정렬, 꼬리가 같으면 머리 순서대로 오름차순 정렬
        Arrays.sort(targets, (a,b) -> {
            if(a[1] == b[1]) return a[0] - b[0]; // 같으면
            // 같지 않으면
            return a[1] - b[1];
        });
        // 첫번째 꼬리 변수 세팅
        int end = 0;
        
        // 모든 미사일 감지(반복문)
        for(int[] target : targets){
            int s = target[0];
            int e = target[1];
         // 꼬리가 다음 머리보다 이상이면
            if(end <= s){
                // 새로운 레이저 필요
                answer++;
                // 꼬리값 갱신 
                end = e;
            }  
        }
        
        return answer;
    }
}