import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int T, person, best, result;
	static int[][] info;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			person = Integer.parseInt(br.readLine());
			info = new int[person][2];
			
			for (int j = 0; j < person; j++) {

				st = new StringTokenizer(br.readLine());
				
				info[j][0] = Integer.parseInt(st.nextToken());
				info[j][1] = Integer.parseInt(st.nextToken());				
			}
			
			Arrays.sort(info, (a, b) -> a[0] - b[0]);
			result = 0;
			best = Integer.MAX_VALUE;
			
			for (int j = 0; j < person; j++) {
				if(info[j][1] < best){
					result++;
					best = info[j][1];
				}
				
			}
			
			System.out.println(result);
		}
		
	}
}
