package 삼성DX알고리즘.그리디알고리즘;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class NO_20_Knapsack {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for (int l = 1; l <= tc; l++) {
			sb.append("#" + l + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int limit = Integer.parseInt(st.nextToken());
			int bag[][] = new int[n + 1][2];
			int map[][] = new int[n + 1][limit + 1]; // 가방정보-부피 테이블을 만들어서 값을 저장해 나간다. 끝에 있는것이 최대 가치를 가진다.
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				bag[i][0] = Integer.parseInt(st.nextToken()); // 부피
				bag[i][1] = Integer.parseInt(st.nextToken()); // 가치
			}
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= limit; j++) {
					if (bag[i][0] > j) {
						map[i][j] = map[i - 1][j]; // 부피가 j보디 크다면 이전에 구한 해당 무게에서의 최대 가치를 가져온다.
					} else { // 값을 넣을 수 있을경우
						map[i][j] = Math.max(map[i - 1][j], map[i - 1][j - bag[i][0]] + bag[i][1]);
					}
				}
			}

			sb.append(map[n][limit]).append("\n");
		}

		System.out.println(sb);
	}
}
