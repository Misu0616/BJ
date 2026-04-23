import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static String N;
	static int[] arr;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = br.readLine();
		arr = new int[N.length()];
		
		for(int i = 0; i < N.length(); i++) {
			arr[i] = Integer.parseInt(String.valueOf(N.charAt(i)));
		}
		
		Arrays.sort(arr);
		
		for(int i = N.length()-1; i >= 0; i--) {
			System.out.print(arr[i]);
		}
	}
}
