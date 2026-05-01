class Solution {
    
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        
        dfs(numbers, target, 0, 0); // (배열, 목표값, 현재 인덱스, 현재까지의 합)
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int index, int sum) {
        // 1. 탈출 조건: 모든 숫자를 다 사용했을 때
        if (index == numbers.length) {
            // 최종 합계가 target과 같으면 정답 카운트 증가
            if (sum == target) answer++;
            return;
        }

        // 2. 수행 동작: 현재 숫자를 더하는 경우와 빼는 경우를 각각 호출
        dfs(numbers, target, index + 1, sum + numbers[index]);
        dfs(numbers, target, index + 1, sum - numbers[index]);
    }
}