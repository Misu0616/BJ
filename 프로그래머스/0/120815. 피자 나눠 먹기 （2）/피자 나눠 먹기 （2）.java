class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // 70%만 통과함 ㅠ
        for(int i=1; i<=6; i++){
            if( (n*i) % 6 == 0) { 
                answer = (n*i)/6;
                break;
            }
        }
        
        return answer;
    }
}