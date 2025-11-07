
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int T, N, M, K, X, Y, result;
	static boolean bchu[][];
	static boolean visit[][];
	static StringTokenizer st;
	static int dy[] = {-1, 1, 0, 0};
	static int dx[] = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			bchu = new boolean[N][M];
			visit = new boolean[N][M];
			result = 0;
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				
				X = Integer.parseInt(st.nextToken());
				Y = Integer.parseInt(st.nextToken());
				bchu[X][Y] = true;
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(bchu[i][j] == false || visit[i][j]) continue;
					dfs(i, j);
					result++;
				}
			}
			System.out.println(result);
		}
	}
		static void dfs(int y, int x) {
			// 방문 체크
			visit[y][x] = true;
			
			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				
				// 새로운 좌표(ny, nx)에 대한 범위 체크, visit 체크
				if(ny < 0 || nx < 0 || ny >= N || nx >= M || bchu[ny][nx] == false || visit[ny][nx]) continue;
				
				dfs(ny, nx);
			
		}

	}

}
