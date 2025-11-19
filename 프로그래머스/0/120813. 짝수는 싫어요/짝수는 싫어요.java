import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n/2];
            
        if(n % 2 == 0){
            answer = new int[n/2];
            for(int i = 0, j = 1; i <= n/2 && j <= n; i++, j += 2){
                answer[i] = j;
            }
        }
            
        if(n % 2 != 0){
            answer = new int[n/2+1];
            for(int i = 0, j = 1; i <= n/2 + 1 && j <= n; i++, j += 2){
                answer[i] = j;
            }
        }
    return answer;
    }
}