package 伙己DX舅绊府硫.赛;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class NO_32_赛 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int l = 1; l <= tc; l++) {
			sb.append("#" + l + " ");
			int n = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> qu = new PriorityQueue<>(Collections.reverseOrder());

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int cmd = Integer.parseInt(st.nextToken());
				if (cmd == 1) {
					qu.add(Integer.parseInt(st.nextToken()));
				} else if (cmd == 2) {
					if (!qu.isEmpty()) {
						sb.append(qu.poll() + " ");
					} else {
						sb.append(-1).append(" ");
					}
				}
			}

			sb.append("\n");

		}

		System.out.println(sb);

	}
}
