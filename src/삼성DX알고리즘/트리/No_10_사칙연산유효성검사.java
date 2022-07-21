package 삼성DX알고리즘.트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_10_사칙연산유효성검사 {
	static String problem;
	static int n;
	static String arr[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int l = 1; l <= 10; l++) {
			sb.append("#" + l + " ");

			n = Integer.parseInt(br.readLine());
			arr = new String[n + 1];
			problem = "";

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				arr[Integer.parseInt(st.nextToken())] = st.nextToken();
			}

			calc(1);

			int before = 0;
			boolean flag = true;
			for (int i = 0; i < problem.length(); i++) {
				int num = problem.charAt(i) - '0';
				if (!(num >= 0 && num <= 9) && i == 0) {
					flag = false;
					break;
				}

				if ((before < 0 || before > 9) && (num < 0 || num > 9)) {
					flag = false;
					break;
				}

				if (num >= 0 && num <= 9) {
					before = num;
				} else {
					before = num;
				}
			}

			if (flag) {
				sb.append(1);
			} else {
				sb.append(0);
			}

			sb.append("\n");
		}

		System.out.println(sb);

	}

	private static void calc(int node) {
		if (node > n) {
			return;
		}

		calc(2 * node);
		problem += arr[node];
		calc(2 * node + 1);
	}

}
