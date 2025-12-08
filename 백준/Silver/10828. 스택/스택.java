import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Stack<String> s = new Stack<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String orders = st.nextToken();
			
			switch (orders) {
			case "push": {
				orders = st.nextToken();
				s.push(orders);
			} break;
			
			case "pop" : {
				if(s.size() == 0) System.out.println(-1);
				else {
					System.out.println(s.pop());
				}
				
			} break;
			case "size" : {
				System.out.println(s.size());
			} break;
			
			case "empty" : {
				if(s.size() == 0) System.out.println(1);
				else System.out.println(0);
			} break;
			
			case "top":{
				if(s.size() == 0) System.out.println(-1);
				else System.out.println(s.peek());
			} break;
			}
		}

	}

}
