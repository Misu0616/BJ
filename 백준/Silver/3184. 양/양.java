
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int R, C, o, v, totalSheep, totalWolf;
	static boolean visited[][];
	static char map[][];
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
		    String line = br.readLine();
		    for (int j = 0; j < C; j++) {
		        map[i][j] = line.charAt(j);
		    }
		}
		
		for (int i = 0; i < R; i++) {
		    for (int j = 0; j < C; j++) {
		        if (!visited[i][j] && map[i][j] != '#') {
		            o = 0;
		            v = 0;
		            bfs(i, j);

		            if (o > v) totalSheep += o;
		            else totalWolf += v;
		        }
		    }
		}

		System.out.println(totalSheep + " " + totalWolf);
		
	}
	
	static void bfs(int x, int y) {
		
	    Queue<Node> q = new ArrayDeque<>();
	    q.add(new Node(x, y));
	    visited[x][y] = true;

	    switch (map[x][y]) {
	    case 'o': o++; break;
	    case 'v': v++; break;
	}

	    while (!q.isEmpty()) {
	        Node cur = q.poll();
	        int cx = cur.x;
	        int cy = cur.y;

	        for (int d = 0; d < 4; d++) {
	            int nx = cx + dx[d];
	            int ny = cy + dy[d];

	            if (nx < 0 || ny < 0 || nx >= R || ny >= C || visited[nx][ny] || map[nx][ny] == '#') continue;

	            visited[nx][ny] = true;
	            // 여기는 if 쓰려고 했는데 그냥 위랑 통일해봄
	            switch (map[nx][ny]) {
	            case 'o': o++; break;
	            case 'v': v++; break;
	        }

	            q.add(new Node(nx, ny));
	        }
	    }
	}
	
	static class Node{
	    int x;
	    int y;

	    Node(int x,int y){
	        this.x = x;
	        this.y = y;
	    }
	}
}