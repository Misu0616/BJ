import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        // 현 위지 = 왼쪽 + 위쪽 => 점화식 세움
        int[][] grid = new int[n+1][m+1];
        
        for(int[] p : puddles){
            grid[p[1]][p[0]] = -1; // 물웅덩이 표시
        }
        
        grid[1][1] = 1;
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(i==1 && j==1) continue; // 시작점 패스
                if(grid[i][j] == -1){
                // 물웅덩이 패스해야 하는데 -1 그대로 두면 다른 값 계산이 이상해져서 0으로 변환
                    grid[i][j] = 0;
                    continue;
                }
                grid[i][j] = ((j>1 ? grid[i][j-1] : 0) + (i>1 ? grid[i-1][j] : 0)) % 1000000007;
            }
        }
        
        return grid[n][m];
    }
}