import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

import org.w3c.dom.Node;

public class Main {

	static int N, K;
	static boolean[] visit = new boolean[100001];
	
	public static void main(String[] args) throws Exception {
		// 걸을 때 : X-1 또는 X+1 
		// 순간 이동 : 2*X
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		System.out.println(bfs(N, K));
	}
	
	static int bfs(int n, int k) {
		Queue<Node> q = new ArrayDeque<>();

		visit[N] = true;
		q.offer(new Node(n, 0)); // 시작 위치 0초
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			if(node.x == K) return node.time; // 둘이 같은 곳에 서있을 때
			
			int wMinus = node.x - 1;
			int wPlus = node.x + 1;
			int wDouble = node.x * 2;
			
			if(wMinus >= 0 && wMinus <= 100000 && !visit[wMinus]) {
				visit[wMinus] = true;
				q.offer(new Node(wMinus, node.time + 1));
			}

			if(wPlus >= 0 && wPlus <= 100000 && !visit[wPlus]) {
				visit[wPlus] = true;
				q.offer(new Node(wPlus, node.time + 1));
			}
			
			if(wDouble >= 0 && wDouble <= 100000 && !visit[wDouble]) {
				visit[wDouble] = true;
				q.offer(new Node(wDouble, node.time + 1));
			}
			
		} return -1;
	}

	static class Node{
		int x;
		int time;
		public Node(int x, int time) {
			this.x = x;
			this.time = time;
		}
	}
}











