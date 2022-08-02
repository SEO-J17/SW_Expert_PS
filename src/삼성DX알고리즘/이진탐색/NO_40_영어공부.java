package 삼성DX알고리즘.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NO_40_영어공부 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int l = 1; l <= tc; l++) {
			sb.append("#" + l + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			boolean arr[] = new boolean[1000001];
			st = new StringTokenizer(br.readLine());
			int last_num = 0;
			for (int i = 0; i < n; i++) {
				int temp = Integer.parseInt(st.nextToken());
				if (i == n - 1) {
					last_num = temp;
				}
				arr[temp] = true;
			}

			int start = 1;
			int end = 1;
			int cnt = 0;
			int max = p + 1;
			while (end <= last_num) {
				if (arr[end]) {
					cnt++;
					end++;
					max = Math.max(max, cnt);
				} else {
					if (p == 0) {
						max = Math.max(max, cnt);
						if (!arr[start]) {
							p++;
						}
						start++;
						cnt--;
					} else {
						p--;
						cnt++;
						end++;
					}
				}
			}
			
			sb.append(max).append("\n");
			
		}
		System.out.println(sb);
	}
}
