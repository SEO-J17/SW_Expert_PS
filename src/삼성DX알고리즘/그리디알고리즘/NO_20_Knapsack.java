package �ＺDX�˰���.�׸���˰���;

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
			int map[][] = new int[n + 1][limit + 1]; // ��������-���� ���̺��� ���� ���� ������ ������. ���� �ִ°��� �ִ� ��ġ�� ������.
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				bag[i][0] = Integer.parseInt(st.nextToken()); // ����
				bag[i][1] = Integer.parseInt(st.nextToken()); // ��ġ
			}
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= limit; j++) {
					if (bag[i][0] > j) {
						map[i][j] = map[i - 1][j]; // ���ǰ� j���� ũ�ٸ� ������ ���� �ش� ���Կ����� �ִ� ��ġ�� �����´�.
					} else { // ���� ���� �� �������
						map[i][j] = Math.max(map[i - 1][j], map[i - 1][j - bag[i][0]] + bag[i][1]);
					}
				}
			}

			sb.append(map[n][limit]).append("\n");
		}

		System.out.println(sb);
	}
}
