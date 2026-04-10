
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, result;
	static int graph[][];
	static boolean visited[];
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u][v] = graph[v][u] = 1;
		}
		
		for(int i = 1; i <= N; i++) {
			if(!visited[i]) {
				//dfs(i);
				bfs(i);
				result++;
			}
		}
		
		System.out.println(result);
		
	}
	
	static void dfs(int v) {
		
		visited[v] = true;
		
		for(int i = 0; i <= N; i++) {
			if(graph[v][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
		
	}
	
	static void bfs(int v) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(v);
		visited[v] = true;
		
		while(!q.isEmpty()) {
			int result2 = q.poll();
			
			for(int i = 0; i<= N; i++) {
				if(graph[result2][i] == 1 && !visited[i]) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}
		
	}

}
