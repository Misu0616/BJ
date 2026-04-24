import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        ArrayList<Integer> list = new ArrayList<>();
        
        int jindo = (int)Math.ceil((100 - progresses[0]) / (double)speeds[0]);
        int count = 1;
        
        for(int i=1; i<progresses.length; i++){
            int day =  (int)Math.ceil((100 - progresses[i]) / (double)speeds[i]);
            if(day<=jindo) {
                count++;
            }
            else {
                list.add(count);
                count = 1;
                jindo = day;
            }
        }
        
            
        list.add(count);
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}