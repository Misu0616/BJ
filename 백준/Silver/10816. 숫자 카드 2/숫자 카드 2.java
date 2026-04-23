import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] arr1, arr2, result;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr1 = new int[N];
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr1[i] = Integer.parseInt(st1.nextToken());
		}
		
		M = Integer.parseInt(br.readLine());
		arr2 = new int[M];
		result = new int[M];
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < M; i++) {
			arr2[i] = Integer.parseInt(st2.nextToken());
		}
		
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < N; i++) {
			
			if(map.containsKey(arr1[i])) {
			    map.put(arr1[i], map.get(arr1[i]) + 1);
			} else {
			    map.put(arr1[i], 1);
			}
		}

		for (int i = 0; i < M; i++) {
			System.out.print(map.getOrDefault(arr2[i], 0) + " ");
		}
	}
}
