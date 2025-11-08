import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        int total = 0;
        for(int w : works){
            total += w;
        }
        
        // 야근할 필요가 있는지 확인
        if(total < n) return 0;
        
        // 우선순위 큐(내림차순)
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int w : works){
            q.add(w);
        }
        
        for(int i=0; i<n; i++){
            int maxW = q.poll(); // 최댓값 꺼내짐
            maxW--;
            q.add(maxW);
        }
        
        // 야근 지수 구하기
        while(!q.isEmpty()){
            int w = q.poll();
            answer += (long) w * w;
        }
        return answer;
    }
}