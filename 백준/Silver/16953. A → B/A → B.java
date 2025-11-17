
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// 2를 곱한다.
	// 1을 수의 가장 오른쪽에 추가한다.  (문자열 덧셈)
	// A를 B로 바꾸는데 필요한 연산의 최솟값에 1을 더한 값을 출력한다. 만들 수 없는 경우에는 -1을 출력
	
	static int a, c, result;
	static String b;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		a = Integer.parseInt(st.nextToken());
		b = st.nextToken();
		c = Integer.parseInt(b);
		
		while(c > a) {
			if(b.charAt(b.length() - 1) == '1') { // 맨 끝자리가 1이면 문자열 빼기

				b = b.substring(0, b.length() - 1);
				c = Integer.parseInt(b);
				
				result++;
			}
			
			else if (c%2 == 0) { // 짝수면 나누기 2
				c = c / 2;
				b = Integer.toString(c);
				result++;
			} 
			
			else {
				System.out.println(-1);
				return;
			}
		
		}
		
		if(c == a) System.out.println(result + 1);
		else System.out.println(-1);
		
	}
}
