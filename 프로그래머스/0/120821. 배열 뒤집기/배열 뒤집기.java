import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        int[] newa = new int[num_list.length];
        int left = 0;
        int right = num_list.length - 1;

        while(left <= right) {
            newa[left] = num_list[right];
            newa[right] = num_list[left];
            
            left++;
            right--;
        }
        
        return newa;
    }
}
