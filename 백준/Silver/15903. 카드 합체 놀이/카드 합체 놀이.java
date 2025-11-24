
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static long result;
	
	public static void main(String[] args) throws Exception {
		
		   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	       StringTokenizer st = new StringTokenizer(br.readLine());
	        
	        N = Integer.parseInt(st.nextToken());
	        M = Integer.parseInt(st.nextToken());

	        PriorityQueue<Long> pq = new PriorityQueue<>();
	        st = new StringTokenizer(br.readLine());
	        
	        for (int i = 0; i < N; i++) {
	            pq.offer(Long.parseLong(st.nextToken()));
	        }

	        for (int i = 0; i < M; i++) {
	        	
	            long a = pq.poll();
	            long b = pq.poll();
	            
	            long sum = a + b;
	            
	            pq.offer(sum);
	            pq.offer(sum);
	        }

	        result = 0;
	        
	        while (!pq.isEmpty()) {
	            result += pq.poll();
	        }

	        System.out.println(result);
	    }
	}