
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, R, result;
    static ArrayList<Integer>[] graph;
    static int[] visited;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N + 1];
		visited = new int[N+1];
		
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
            graph[u].add(v);
            graph[v].add(u);
		}
		
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }
        
		bfs(R);
		
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(visited[i]).append('\n');
        }
        System.out.print(sb);

	}
	
	static void bfs(int v) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(v);
    	result++;
        visited[v] = result;

        while(!q.isEmpty()) {
        	int count = q.poll();
        	
        	for (int next : graph[count]) {
        	    if (visited[next] == 0) {
        	        q.offer(next);
        	        visited[next] = ++result;
        	    }
        	}
        }
    }

}
