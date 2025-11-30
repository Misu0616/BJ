import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

	static int a, b;
	static boolean arr[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		arr = new boolean[b + 1];
		arr[0] = false;
		arr[1] = false;
		
		for (int i = 2; i <= b; i++) {
			arr[i] = true;
		}
		
		for (int i = 2; i*i <= b; i++) {
			if(arr[i]) {
				for (int j = i*i; j <= b; j+=i) {
					arr[j] = false;
				}
			}
		}
		
		for (int i = a; i <= b; i++) {
			if(arr[i]) {
				System.out.println(i);
			}
		}
		
	}

}
