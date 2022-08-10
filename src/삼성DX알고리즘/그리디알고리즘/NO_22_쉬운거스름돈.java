package 삼성DX알고리즘.그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NO_22_쉬운거스름돈 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for (int l = 1; l <= tc; l++) {
			sb.append("#" + l + "\n");
			int n = Integer.parseInt(br.readLine());
			int arr[] = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };
			int result[] = new int[8];

			for (int i = 0; i < 8; i++) {
				int money = arr[i];
				int cnt = 0;
				while (true) {
					if (n >= money) {
						n -= money;
						cnt++;
					} else {
						break;
					}
				}
				result[i] = cnt;
			}

			for (int d : result) {
				sb.append(d).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
