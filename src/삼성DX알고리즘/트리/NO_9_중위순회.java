package 삼성DX알고리즘.트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NO_9_중위순회 {
	static String data[];
	static int n;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int l = 1; l <= 10; l++) {
			sb.append("#" + l + " ");
			n = Integer.parseInt(br.readLine());
			data = new String[n + 1];
			
			for (int i = 1; i <= n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				data[Integer.parseInt(st.nextToken())] = st.nextToken();
			}
			
			calc(1);
			
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}

	private static void calc(int depth) {
		if (depth > n) {
			return;
		}
		
		calc(depth*2);
		sb.append(data[depth]);
		calc(depth*2 + 1);
		
	}
}
