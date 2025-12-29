
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, distance;
	static boolean[][] friend;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		friend = new boolean[N+1][N+1];
		
		for (int i = 0; i < M; i++) {
		    st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			friend[a][b] = friend[b][a] = true;
		}
		
		int person = 1; // 사람은 1부터 시작
		int min = Integer.MAX_VALUE; // 케빈 베이컨 값을 최대에서 최소로 줄여감

		// 케빈 베이컨의 수가 가장 작은 사람 구하기
		for (int i = 1; i <= N; i++) {
			
		    int result = bfs(i);

		    if (result < min) {
		        min = result;
		        person = i;
		    }
		}

		System.out.println(person);

	}

	static int bfs(int personNum) {
		
		Queue<Integer> q = new ArrayDeque<>(); 
	    boolean[] visited = new boolean[N + 1]; // 연결된 친구 관계 방문 여부
	    int[] dist = new int[N + 1]; // 방문하면서 사람 간의 이동을 거리화

	    q.add(personNum);
		visited[personNum] = true;
		int sum = 0;
		
		while (!q.isEmpty()) {
		    int curNum = q.poll();

		    // 큐를 사용해 distance 구해서 sum으로 보내주기
		    for (int i = 1; i <= N; i++) {
		        if (friend[curNum][i] && !visited[i]) { // 현재 사람과 친구인 i 찾기
		            visited[i] = true;
		            dist[i] = dist[curNum] + 1;
		            q.add(i);
		            sum += dist[i];
		        }
		    }
		}
		
		return sum;
	}

}
