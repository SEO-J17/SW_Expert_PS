package 삼성DX알고리즘.비트연산;

import java.io.*;
import java.util.*;

public class NO_3_동아리실관리하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int l = 1; l <= tc; l++) {
			sb.append("#" + l + " ");
			String str = br.readLine();
			int arr[][] = new int[str.length()][16];
			
			
			//첫날. A가 키를 들고 참석, 책임자 한명 참석하는 경우.
			for (int i = 1; i < 16; i++) {
				if ((i & (1 << (str.charAt(0) - 'A'))) != 0 && (i & 1) != 0) {
					arr[0][i] = 1;
				}
			}

			//다른날. 전날 인원이 최소 한명 참석, 책임자 참석.
			for (int i = 1; i < str.length(); i++) {
				for (int j = 1; j < 16; j++) {
					if (arr[i - 1][j] == 0) {
						continue;
					}
					for (int k = 1; k < 16; k++) {
						if ((k & j) != 0 && (k & (1 << (str.charAt(i) - 'A'))) != 0) {
							arr[i][k] += arr[i - 1][j];
							arr[i][k] %= 1000000007;
						}
					}
				}
			}

			int sum = 0;
			for (int i = 1; i < 16; i++) {
				sum += arr[arr.length - 1][i];
				sum %= 1000000007;
			}
			sb.append(sum).append("\n");
		}

		System.out.println(sb);

	}
}
