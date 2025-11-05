
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, start, result;
	static int memoi[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		start = Integer.parseInt(br.readLine());
		memoi = new int[N+1][N+1];
		memoi[1][1] = start;
		
		for (int i = 2; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 1; j <= i; j++) {
				memoi[i][j] = Integer.parseInt(st.nextToken());
			} 
		}
		
		for (int i = N-1; i >= 1; i--) {
			
			for (int j = 1; j <= i; j++) {
				
				memoi[i][j] += Math.max(memoi[i+1][j], memoi[i+1][j+1]);
				
			}
		} System.out.println(memoi[1][1]);
		
	}

}
