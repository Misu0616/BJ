class Solution {
    public int solution(int slice, int n) {
        int answer = 0;
        
        if(n%slice != 0) answer = n/slice+1;
        else answer = n/slice;
        
        return answer;
        
        // 삼항 연산자 쓰는 것도 연습해보기 
        // return n % slice > 0 ? n/slice+1 : n/slice;
    }
}