import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = {};
        List<String> answerList = new ArrayList<>();
        
        // 1. 시간을 분으로 변환해 정렬
        for(String[] plan : plans){
            String[] time = plan[1].split(":");
            int h = Integer.parseInt(time[0]);
            int m = Integer.parseInt(time[1]);
            // 시작 시간(분)
            plan[1] = String.valueOf(h * 60 + m);
             // 소요 시간
            plan[2] = String.valueOf(Integer.parseInt(plan[2]));
        }
        // 시간 순으로 정렬(1번을 기준으로 정렬)
        Arrays.sort(plans, Comparator.comparingInt(plan -> Integer.parseInt(plan[1])));
        // 멈춘 과제를 저장(스택)
        Stack<String[]> stack = new Stack<>();
        
        // 2. 모든 과제 처리
        for(int i = 0; i < plans.length - 1; i++){
            String subject = plans[i][0];
            int startTime = Integer.parseInt(plans[i][1]);
            int duration = Integer.parseInt(plans[i][2]);
            int nextStart = Integer.parseInt(plans[i+1][1]);
        
        // 2-1 다음 과제 시간까지 끝낼 수 있는가?
        if(startTime + duration <= nextStart){
            // 과제 완료
            answerList.add(subject);
            // 남은 시간
            int remainingTime = nextStart - (startTime + duration); 
        
            // 2-1-1 있으면 남은 시간 판단해 남은 과제 처리
            while(remainingTime > 0 && !stack.isEmpty()){
                String[] pauseTask = stack.pop();
                String pauseSubject = pauseTask[0];
                int pauseDuration = Integer.parseInt(pauseTask[1]);
                
                // 남은 시간으로 밀린 숙제를 모두 처리할 수 있을 때
                if(remainingTime >= pauseDuration){
                    answerList.add(pauseSubject);
                    // 꺼내온 과제를 남아있는 시간에서 차감
                    remainingTime -= pauseDuration; 
                } else { // 모두 처리 불가면 남은 시간으로 밀린 숙제 일부하고 다시 넣기
                    stack.push(new String[]{pauseSubject, String.valueOf(pauseDuration-remainingTime)});
                    break;
                }
            }
        }
        // 2-2 없으면 밀린 과제로 넘김
        else {
            stack.push(new String[]{subject, String.valueOf(duration - (nextStart - startTime))});
        }
    }
    // 3. 마지막 과제는 밀린 과제의 뒤로 넘김
    stack.push(new String[]{plans[plans.length-1][0], plans[plans.length-1][2]});
    
        // 4. 남은 과제 모두 가장 최근에 멈춘 것부터 해결 
    while(!stack.isEmpty()){
        answerList.add(stack.pop()[0]);
    }
    
    answer = answerList.toArray(new String[0]);
        return answer;
    }
}