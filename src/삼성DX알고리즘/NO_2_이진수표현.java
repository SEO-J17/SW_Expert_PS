package 삼성DX알고리즘;

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
			boolean flag = true;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int bit = Integer.parseInt(st.nextToken());
			String num = Integer.toBinaryString(Integer.parseInt(st.nextToken()));
			int cnt = 0;
			for (int i = num.length() - 1; i >= 0; i--) {
				cnt++;
				if (num.charAt(i) - '0' == 0) {
					sb.append("OFF").append("\n");
					flag = false;
					break;
				}
				if(cnt == bit) {
					break;
				}
			}
			
			if(flag) {
				sb.append("ON").append("\n");
			}
		}

		System.out.println(sb);

	}
}
