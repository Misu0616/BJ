import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, result;
	static int graph[][];
	static boolean visited[];
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		graph = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int i = 0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = graph[b][a] = 1;
		}
		
		dfs(1);
		System.out.println(result -1);
		
	}
	
	static void dfs(int v) {
		
		visited[v] = true;
		result++;
		
		for(int i = 0; i <= N; i++) {
			if(graph[v][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
		
	}

}
