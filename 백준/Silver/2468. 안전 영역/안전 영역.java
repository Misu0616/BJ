import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main  {
	
	static int N, safeLine, result;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                safeLine = Math.max(safeLine, map[i][j]); // 0부터 map에서 가장 높은 곳까지 for문 돌려야 하니 max 값 필요함 
            }
        }
        
        // 물 높이 0부터 최대까지 안전 지역 구하기
        for(int i = 0; i <= safeLine; i++) {
            visited = new boolean[N][N];
            int count = 0;
            
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    if(!visited[j][k] && map[j][k] > i) {
                        dfs(j, k, i);
                        count++;
                    }
                }
            }
            
            // 각 안전 지역의 최댓값 저장
            result = Math.max(result, count);
        }
        
        System.out.println(result);
    }
    
    static void dfs(int y, int x, int i) {
        visited[y][x] = true;
        
        for(int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            
            if(ny >= 0 && ny < N && nx >= 0 && nx < N) {
                if(!visited[ny][nx] && map[ny][nx] > i) {
                    dfs(ny, nx, i);
                }
            }
        }
    }
}