package 삼성DX알고리즘.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class NO_19_최장공통수열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for (int l = 1; l <= tc; l++) {
			sb.append("#" + l + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			char[] arr1 = st.nextToken().toCharArray();
			char[] arr2 = st.nextToken().toCharArray();
			int map[][] = new int[arr1.length + 1][arr2.length + 1];

			for (int i = 0; i <= arr1.length; i++) {
				for (int j = 0; j <= arr2.length; j++) {
					if (i == 0 || j == 0) {
						map[i][j] = 0;
						continue;
					}
					if (arr1[i - 1] == arr2[j - 1]) {
						map[i][j] = map[i - 1][j - 1] + 1;
					} else {
						map[i][j] = Math.max(map[i - 1][j], map[i][j - 1]);
					}

				}
			}
			sb.append(map[arr1.length][arr2.length]).append("\n");
		}

		System.out.println(sb);

	}

}