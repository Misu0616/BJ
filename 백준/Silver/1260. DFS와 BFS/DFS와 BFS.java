import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

import org.w3c.dom.Node;

public class Main {
	
	static int N, M, V;
	static int graph[][];
	static boolean visited[];
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		graph = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = graph[b][a] = 1;
		}
		
		dfs(V);
		System.out.println();
        visited = new boolean[N+1]; 
		bfs(V);
		
	}

	static void dfs(int v) {
		visited[v] = true;
		
		System.out.print(v + " ");
		
		for(int i = 0; i<=N; i++) {
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
			int result = q.poll();
			
			System.out.print(result + " ");
			
			for(int i = 0; i <= N; i++) {
				if(graph[result][i] == 1 && !visited[i]) {
					q.offer(i);
		            visited[i] = true;
				}
			}
		}
	}
	
}














