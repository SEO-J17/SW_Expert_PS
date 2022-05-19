package D3;

import java.io.*;
import java.util.*;

public class 일차원정원 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int start = (1 + d + d);
			if (n % start != 0) {
				sb.append("#").append(i + 1).append(" " + (n / start + 1)).append("\n");
			} else {
				sb.append("#").append(i + 1).append(" " + n / start).append("\n");
			}

		}

		System.out.println(sb);

	}
}
