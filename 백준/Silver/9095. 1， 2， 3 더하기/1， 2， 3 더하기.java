import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int t, n;
	static int memoi[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		t = Integer.parseInt(br.readLine());
			
        memoi = new int[11];
        memoi[1] = 1;
        memoi[2] = 2;
        memoi[3] = 4;

        for (int j = 4; j <= 10; j++) {
            memoi[j] = memoi[j - 1] + memoi[j - 2] + memoi[j - 3];
        }

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            sb.append(memoi[n]).append("\n");
        }

        System.out.print(sb);
		
		
	}

}
