
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int max = 100001;
	static int minTime[];
	static int minMethod[];
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		minTime = new int[max];
		minMethod = new int[max];
		Arrays.fill(minTime, -1);
		
		Queue<Integer> q = new ArrayDeque<>();
		
		// 기본 위치 N으로 시작
		q.add(N);
		minTime[N] = 0;
		minMethod[N] = 1;

		
		while(!q.isEmpty()) {
		
			int nowLo = q.poll();
			  
			int plus = nowLo + 1;
			int minus = nowLo - 1;
			int jump = nowLo * 2;
			
			// 1칸 전진 
			if (plus >= 0 && plus < max) {
				if (minTime[plus] == -1) {
	                minTime[plus] = minTime[nowLo] + 1;
	                minMethod[plus] = minMethod[nowLo];
	                q.add(plus);
				}
                else if (minTime[plus] == minTime[nowLo] + 1) {  // 같은 최단 경로
                	minMethod[plus] += minMethod[nowLo];
                }
            }

            // 1칸 후퇴
            if (minus >= 0 && minus < max) {
            	 if (minTime[minus] == -1) {
	               minTime[minus] = minTime[nowLo] + 1;
	               minMethod[minus] = minMethod[nowLo];
	               q.add(minus);
            	 }
            	 else if (minTime[minus] == minTime[nowLo] + 1) {
                 	minMethod[minus] += minMethod[nowLo];
                 }	 
            }

            // 순간이동
            if (jump >= 0 && jump < max) {
            	if (minTime[jump] == -1) {
            		minTime[jump] = minTime[nowLo] + 1;
            		minMethod[jump] = minMethod[nowLo];
	                q.add(jump);
            	}
            	  
                else if (minTime[jump] == minTime[nowLo] + 1) {
                	minMethod[jump] += minMethod[nowLo];
                }
            }

		}
		
		  System.out.println(minTime[K]);
          System.out.println(minMethod[K]);
	}

}
