
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int memoi[][];
	static int N, cost;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		memoi = new int[N][3]; 
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				memoi[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		
		for (int i = 1; i < N; i++) {
			
			// 빨강 -> 이전 집의 (초록, 파랑) 중 최소 + 현재 빨강 비용
			memoi[i][0] = Math.min(memoi[i-1][1], memoi[i-1][2]) + memoi[i][0];
			
			//초록 -> 이전 집의 (빨강, 파랑) 중 최소 + 현재 초록 비용
			memoi[i][1] = Math.min(memoi[i-1][0], memoi[i-1][2]) + memoi[i][1];
			
			// 파랑 -> 이전 집의 (빨강, 초록) 중 최소 + 현재 파랑 비용
			memoi[i][2] = Math.min(memoi[i-1][0], memoi[i-1][1]) + memoi[i][2];
			
		}

		System.out.println(Math.min(memoi[N-1][0], Math.min(memoi[N-1][1], memoi[N-1][2])));
	}


}
