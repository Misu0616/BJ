import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] saying = {"aya", "ye", "woo", "ma"};
        
            for(int i=0; i<babbling.length; i++){
                
                String word = babbling[i];
                
                for(int j=0; j<saying.length; j++){
                    word = word.replace(saying[j], "A");
                }
                
                if(word.contains("A")){
                    
                    String newWord = word.replace("A", "");
                    
                    if(newWord.isEmpty()) answer++;
                } 
                
            }
                
        return answer;
    }
}