package 삼성DX알고리즘.해시;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class NO_25_문자열교집합 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for (int l = 1; l <= tc; l++) {
			sb.append("#" + l + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());

			HashSet<String> set = new HashSet<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n1; i++) {
				set.add(st.nextToken());
			}

			int result = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n2; i++) {
				if (set.contains(st.nextToken())) {
					result++;
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

}
