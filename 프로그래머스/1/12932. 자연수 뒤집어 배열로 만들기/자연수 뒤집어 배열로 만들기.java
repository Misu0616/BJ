class Solution {
    public int[] solution(long n) {
        
        String s = String.valueOf(n);
            
        int[] answer = new int[s.length()];
        
        for(int i=0; i<s.length(); i++){
            
            // 맨 뒤부터 점점 앞으로 이동하기
            char c = s.charAt(s.length() - 1 - i);
            
            // 문자열을 숫자로 변환
            answer[i] = c - '0';
        }
            
        return answer;
    }
}