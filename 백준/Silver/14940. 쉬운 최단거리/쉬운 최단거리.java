
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, result, startX, startY;
	static int map[][];
	static boolean visit[][];
	static StringTokenizer st;
	static Queue <Node> queue = new ArrayDeque<>();
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean [N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					startY = i;
					startX = j;
				} 
			}
		}
		
		bfs(startY, startX);
		
		// 방문하지 않은 1은 -1로 변경
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) map[i][j] = 0;
				if(map[i][j] == 1 && !visit[i][j]) map[i][j] = -1;
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	static void bfs(int y, int x) {
		
		queue.offer(new Node(y, x)); // 시작점을 queue에 담고 시작
		visit[y][x] = true; // 큐에 넣을 때 visit 체크
		map[y][x] = 0;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll(); // 여기서 꺼낸 데이터에서부터 갈 수 있는 좌표
			
			for (int d = 0; d < 4; d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];
				
				// 새로운 좌표(ny, nx)에 대한 범위 체크, visit 체크
				if(ny < 0 || nx < 0 || ny >= N || nx >= M || map[ny][nx] == 0 || visit[ny][nx]) continue;
				
				visit[ny][nx] = true;
				map[ny][nx] = map[node.y][node.x] + 1;
				queue.offer(new Node(ny, nx));
			}
		}
	}
	
	static class Node{
		int y, x;
		Node(int y, int x){
			this.y = y; this.x = x;
		}
		
	}
}
