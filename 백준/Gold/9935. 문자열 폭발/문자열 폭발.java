
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	static String list, e;
	static Stack<Character> s = new Stack<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		list = br.readLine();
		e = br.readLine();
		
		for (char c : list.toCharArray()) {
			s.push(c);
			
			if(s.size() >= e.length()) {
				boolean findW = true;
				
				for (int i = 0; i < e.length(); i++) {
					if(s.get(s.size() - e.length() + i) != e.charAt(i)) { 
						// 스택 사이즈 - 폭발 문자열 길이 + i 이 폭발 단어랑 같지 않을 때
						// 
						
						findW = false;
						break;
					}
				}
				
				if (findW) {
		            for (int i = 0; i < e.length(); i++) s.pop();
		        }
			}
		}
		
		if (s.isEmpty()) System.out.println("FRULA");
		else {
		    StringBuilder sb = new StringBuilder();
		    for (char c : s) sb.append(c);
		    System.out.println(sb);
		}

	}

}
