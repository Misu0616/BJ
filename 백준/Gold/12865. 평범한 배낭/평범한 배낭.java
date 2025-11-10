
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, K; // N 물품 수, k 가방 무게 최대, w 물건 무게, v 물건 가치
	static int[] W;
	static int[] V;
	
	static int[][] bag;
	static int[] memoi;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		W = new int[N+1];
	    V = new int[N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }
		
        memoi = new int[K+1];

        for (int i = 1; i <= N; i++) {
            for (int w = K; w >= W[i]; w--) {
            	memoi[w] = Math.max(memoi[w], memoi[w - W[i]] + V[i]);
            }
        }

        System.out.println(memoi[K]);
		
	}

}
