import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] num;
    static int[] cal = new int[4]; 
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static StringTokenizer st; 

    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N];

        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < 4; i++) {
            cal[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, num[0]); // 첫 숫자부터 시작
        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int index, int result) {
        if(index == N) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for(int i = 0; i < 4; i++) {
            if(cal[i] > 0) {
                cal[i]--; // 연산자 사용
                int nextResult = 0;
                switch(i) {
                    case 0: nextResult = result + num[index]; break;
                    case 1: nextResult = result - num[index]; break;
                    case 2: nextResult = result * num[index]; break;
                    case 3: nextResult = result / num[index]; break;
                }
                dfs(index + 1, nextResult);
                cal[i]++; // 연산자 복구
            }
        }
    }
}