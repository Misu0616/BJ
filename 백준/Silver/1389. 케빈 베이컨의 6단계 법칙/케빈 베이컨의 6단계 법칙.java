
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
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
		
		int answer = 1;
		int min = Integer.MAX_VALUE;

		for (int i = 1; i <= N; i++) {
		    int result = bfs(i);

		    if (result < min) {
		        min = result;
		        answer = i;
		    }
		}

		System.out.println(answer);

		
	}

	static int bfs(int start) {
		
		Queue<Integer> q = new LinkedList<>(); 
	    boolean[] visited = new boolean[N + 1];
	    int[] dist = new int[N + 1];

	    q.add(start);
		visited[start] = true;

		while (!q.isEmpty()) {
		    int cur = q.poll();

		    for (int i = 1; i <= N; i++) {
		        if (friend[cur][i] && !visited[i]) {
		            visited[i] = true;
		            dist[i] = dist[cur] + 1; 
		            q.add(i);
		        }
		    }
		}
		
		int sum = 0;
		for (int i = 1; i <= N; i++) {
		    sum += dist[i];
		}
		return sum;
	}

}
