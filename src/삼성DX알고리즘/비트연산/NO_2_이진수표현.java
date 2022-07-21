package 삼성DX알고리즘.비트연산;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NO_2_이진수표현 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int l = 1; l <= tc; l++) {
			sb.append("#" + l + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int bit = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			boolean flag = true;
			for (int i = 0; i < bit; i++) {
				if ((num & (1 << i)) == 0) {
					flag = false;
					break;
				}
			}
			
			if (flag) {
				sb.append("ON");
			} else {
				sb.append("OFF");
			}
			sb.append("\n");
			
		}

		System.out.println(sb);

	}
}
