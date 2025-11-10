import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, K, W, V, result; // N 물품 수, k 가방 무게 최대, w 물건 무게, v 물건 가치
	static int[][] bag;
	static int[][] memoi;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		bag = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			W = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());
			
			bag[i][0] = W;
			bag[i][1] = V;
		} 
		
        memoi = new int[N+1][K+1];
        
		for (int i = 1; i <= N; i++) {
            for (int w = 0; w <= K; w++) {
            	memoi[i][w] = memoi[i-1][w]; // 선택하지 않음
                
                if (w - bag[i-1][0] >= 0) { // 선택 가능한 경우
                	memoi[i][w] = Math.max(memoi[i][w], memoi[i-1][w - bag[i-1][0]] + bag[i-1][1]);
                }
            }
        }
        
        System.out.println(memoi[N][K]);
		
	}

}
